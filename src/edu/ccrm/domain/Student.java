package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Student entity.
 * Constructor signature matches code that calls: new Student(regNo, fullName, email)
 */
public class Student extends Person {
    private final String regNo;
    private String email;
    private boolean active;
    private final LocalDate createdAt;
    private final List<Course> enrolledCourses;

    public Student(String regNo, String fullName, String email) {
        super(fullName);                // Person(fullName)
        this.regNo = regNo;
        this.email = email;
        this.active = true;
        this.createdAt = LocalDate.now();
        this.enrolledCourses = new ArrayList<>();
    }

    // getters
    public String getRegNo() {
        return regNo;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // setters / mutators
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public void deactivate() {
        this.active = false;
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void unenrollCourse(Course course) {
        enrolledCourses.remove(course);
    }

    @Override
    public String toString() {
        return String.format("Student[regNo=%s, name=%s, email=%s, active=%s, createdAt=%s, enrolled=%d]",
                regNo, getFullName(), email, active, createdAt, enrolledCourses.size());
    }
}
