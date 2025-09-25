package edu.ccrm.domain;

/**
 * Abstract base class for people (Student / Instructor).
 */
public abstract class Person {
    private String fullName;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // subclasses should provide role string
    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + ": " + fullName;
    }
}
