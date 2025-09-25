package edu.ccrm.exception;

/**
 * Custom checked exception thrown when a student
 * tries to enroll in courses exceeding the allowed
 * maximum credits per semester.
 */
public class MaxCreditLimitExceededException extends Exception {
    public MaxCreditLimitExceededException(String message) {
        super(message);
    }
}
