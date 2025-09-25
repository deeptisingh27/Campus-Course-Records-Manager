package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Student;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    private static final Path STUDENT_CSV = Paths.get("test-data/students.csv");
    private static final Path COURSE_CSV = Paths.get("test-data/courses.csv");

    // Import Students from CSV
    public static List<Student> importStudents() {
        List<Student> students = new ArrayList<>();
        if (!Files.exists(STUDENT_CSV)) {
            System.out.println("Students CSV not found at " + STUDENT_CSV.toAbsolutePath());
            return students;
        }

        try (BufferedReader br = Files.newBufferedReader(STUDENT_CSV)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length < 3) continue;
                students.add(new Student(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        } catch (IOException e) {
            System.out.println("Error importing students: " + e.getMessage());
        }

        System.out.println(students.size() + " students imported successfully from CSV.");
        return students;
    }

    // Import Courses from CSV
    public static List<Course> importCourses() {
        List<Course> courses = new ArrayList<>();
        if (!Files.exists(COURSE_CSV)) {
            System.out.println("Courses CSV not found at " + COURSE_CSV.toAbsolutePath());
            return courses;
        }

        try (BufferedReader br = Files.newBufferedReader(COURSE_CSV)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length < 6) continue;
                courses.add(new Course(
                        parts[0].trim(),
                        parts[1].trim(),
                        Integer.parseInt(parts[2].trim()),
                        parts[3].trim(),
                        Semester.valueOf(parts[4].trim().toUpperCase()),
                        parts[5].trim()
                ));
            }
        } catch (IOException e) {
            System.out.println("Error importing courses: " + e.getMessage());
        }

        System.out.println(courses.size() + " courses imported successfully from CSV.");
        return courses;
    }

    // Recursive directory size
    public static long getDirectorySize(Path dir) {
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            System.out.println("Directory not found: " + dir.toAbsolutePath());
            return 0;
        }

        long size = 0;
        try (var stream = Files.walk(dir)) {
            size = stream.filter(Files::isRegularFile)
                         .mapToLong(p -> {
                             try {
                                 return Files.size(p);
                             } catch (IOException e) {
                                 return 0L;
                             }
                         })
                         .sum();
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
        return size;
    }

    // Backup files to timestamped folder
    public static void backupFiles(Path backupRoot, List<Student> students, List<Course> courses) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        Path backupDir = backupRoot.resolve("backup_" + timestamp);

        try {
            Files.createDirectories(backupDir);

            // Backup students
            Path studentFile = backupDir.resolve("students.csv");
            try (BufferedWriter bw = Files.newBufferedWriter(studentFile)) {
                for (Student s : students) {
                    bw.write(String.join(",", s.getRegNo(), s.getFullName(), s.getEmail()));
                    bw.newLine();
                }
            }

            // Backup courses
            Path courseFile = backupDir.resolve("courses.csv");
            try (BufferedWriter bw = Files.newBufferedWriter(courseFile)) {
                for (Course c : courses) {
                    bw.write(String.join(",", c.getCode(), c.getTitle(), String.valueOf(c.getCredits()),
                            c.getInstructor(), c.getSemester().name(), c.getDepartment()));
                    bw.newLine();
                }
            }

            long size = getDirectorySize(backupDir);
            System.out.println("Backup created at: " + backupDir.toAbsolutePath() + " (size: " + size + " bytes)");

        } catch (IOException e) {
            System.out.println("Error creating backup: " + e.getMessage());
        }
    }
}
