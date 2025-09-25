package edu.ccrm.service;

import edu.ccrm.domain.*;

import java.util.*;

public class TranscriptServiceImpl implements TranscriptService {
    private final List<Grade> grades = new ArrayList<>();

    @Override
    public void recordGrade(Student student, Course course, String letterGrade) {
        // Check if grade already exists
        for (Grade g : grades) {
            if (g.getStudent().equals(student) && g.getCourse().equals(course)) {
                g.setLetterGrade(letterGrade); // update
                return;
            }
        }
        grades.add(new Grade(student, course, letterGrade));
    }

    @Override
    public void printTranscript(Student student) {
        System.out.println("\nTranscript for " + student + ":");
        grades.stream()
              .filter(g -> g.getStudent().equals(student))
              .forEach(System.out::println);
    }
}
