package edu.ccrm.domain;

import java.time.LocalDateTime;

public class Enrollment {
    private final String studentId;
    private final String courseCode;
    private final LocalDateTime enrolledAt;
    private Grade grade;

    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.enrolledAt = LocalDateTime.now();
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade g) { this.grade = g; }

    @Override
    public String toString() {
        return studentId + " -> " + courseCode + " @" + enrolledAt + " grade=" + grade;
    }
}
