package edu.ccrm.exception;

/**
 * Custom checked exception thrown when a student
 * is already enrolled in a course.
 */
public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
}
