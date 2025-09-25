package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;

public interface EnrollmentService {
    /**
     * Enroll the given student in the given course.
     * Throws DuplicateEnrollmentException if already enrolled.
     * Throws MaxCreditLimitExceededException if adding course exceeds credit limit.
     */
    void enroll(Student student, Course course)
            throws DuplicateEnrollmentException, MaxCreditLimitExceededException;

    void unenroll(Student student, Course course);

    void listEnrollments(Student student);
}
