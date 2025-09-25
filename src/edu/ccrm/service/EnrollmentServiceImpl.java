package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;

public class EnrollmentServiceImpl implements EnrollmentService {

    private static final int MAX_CREDITS_PER_SEMESTER = 20; // change as required

    @Override
    public void enroll(Student student, Course course)
            throws DuplicateEnrollmentException, MaxCreditLimitExceededException {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }

        // duplicate check
        if (student.getEnrolledCourses().stream().anyMatch(c -> c.getCode().equalsIgnoreCase(course.getCode()))) {
            throw new DuplicateEnrollmentException("Student " + student.getRegNo() + " is already enrolled in " + course.getCode());
        }

        // credit rule
        int currentCredits = student.getEnrolledCourses().stream()
                .mapToInt(Course::getCredits)
                .sum();

        if (currentCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            throw new MaxCreditLimitExceededException("Cannot enroll: credit limit (" + MAX_CREDITS_PER_SEMESTER + ") exceeded");
        }

        // enroll
        student.enrollCourse(course);
        System.out.println("Enrolled " + student.getRegNo() + " -> " + course.getCode());
    }

    @Override
    public void unenroll(Student student, Course course) {
        if (student == null || course == null) return;
        student.unenrollCourse(course);
        System.out.println("Unenrolled " + student.getRegNo() + " from " + course.getCode());
    }

    @Override
    public void listEnrollments(Student student) {
        if (student == null) {
            System.out.println("Student is null");
            return;
        }
        System.out.println("Enrollments for " + student.getRegNo() + ":");
        student.getEnrolledCourses().forEach(c -> System.out.println(" - " + c));
    }
}
