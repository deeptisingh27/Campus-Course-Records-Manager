package edu.ccrm.cli;

import edu.ccrm.domain.*;
import edu.ccrm.service.*;
import edu.ccrm.io.FileIO;

import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        TranscriptService transcriptService = new TranscriptServiceImpl();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCampus Course & Records Manager:");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. Record Grade");
            System.out.println("7. Print Transcript");
            System.out.println("8. Update Student");
            System.out.println("9. Deactivate Student");
            System.out.println("10. Update Course");
            System.out.println("11. Deactivate Course");
            System.out.println("12. Import Students from CSV");
            System.out.println("13. Import Courses from CSV");
            System.out.println("14. Backup Data & Show Size");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter regNo: ");
                    String reg = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    studentService.addStudent(new Student(reg, name, email));
                    System.out.println("Student added successfully!");
                }
                case 2 -> studentService.getAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter credits: ");
                    int cr = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter instructor: ");
                    String instructor = sc.nextLine();
                    System.out.print("Enter semester (INTERIM/WINTER/SPRING/SUMMER/FALL): ");
                    Semester sem = Semester.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    courseService.addCourse(new Course(code, title, cr, instructor, sem, dept));
                    System.out.println("Course added successfully!");
                }
                case 4 -> courseService.getAll().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Enter student regNo: ");
                    Student s = studentService.findByRegNo(sc.nextLine());
                    System.out.print("Enter course code: ");
                    Course c = courseService.findByCode(sc.nextLine());
                    try {
                        enrollmentService.enroll(s, c);
                        System.out.println("Student enrolled successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.print("Enter student regNo: ");
                    Student s = studentService.findByRegNo(sc.nextLine());
                    if (s == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter course code: ");
                    Course c = courseService.findByCode(sc.nextLine());
                    if (c == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    System.out.print("Enter grade (S/A/B/C/D/F): ");
                    String grade = sc.nextLine().toUpperCase();
                    transcriptService.recordGrade(s, c, grade);
                    System.out.println("Grade recorded successfully.");
                }
                case 7 -> {
                    System.out.print("Enter student regNo: ");
                    Student s = studentService.findByRegNo(sc.nextLine());
                    if (s != null) {
                        transcriptService.printTranscript(s);
                        System.out.println("Transcript printed successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 8 -> {
                    System.out.print("Enter regNo to update: ");
                    String reg = sc.nextLine();
                    System.out.print("New name: ");
                    String name = sc.nextLine();
                    System.out.print("New email: ");
                    String email = sc.nextLine();
                    studentService.updateStudent(reg, name, email);
                    System.out.println("Student updated successfully!");
                }
                case 9 -> {
                    System.out.print("Enter regNo to deactivate: ");
                    studentService.deactivateStudent(sc.nextLine());
                    System.out.println("Student deactivated successfully!");
                }
                case 10 -> {
                    System.out.print("Enter course code: ");
                    String code = sc.nextLine();
                    System.out.print("New title: ");
                    String title = sc.nextLine();
                    System.out.print("New instructor: ");
                    String instructor = sc.nextLine();
                    courseService.updateCourse(code, title, instructor);
                    System.out.println("Course updated successfully!");
                }
                case 11 -> {
                    System.out.print("Enter course code to deactivate: ");
                    courseService.deactivateCourse(sc.nextLine());
                    System.out.println("Course deactivated successfully!");
                }
                case 12 -> {
                    List<Student> imported = FileIO.importStudents();
                    imported.forEach(studentService::addStudent);
                }
                case 13 -> {
                    List<Course> imported = FileIO.importCourses();
                    imported.forEach(courseService::addCourse);
                }
                case 14 -> {
                    FileIO.backupFiles(Paths.get("backups"),
                            studentService.getAll(),
                            courseService.getAll());
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice, try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
