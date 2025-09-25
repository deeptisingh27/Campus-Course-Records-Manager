package edu.ccrm.domain;

public class Grade {
    private Student student;
    private Course course;
    private String letterGrade; // e.g., A, B, C, D, F

    public Grade(Student student, Course course, String letterGrade) {
        this.student = student;
        this.course = course;
        this.letterGrade = letterGrade;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getLetterGrade() { return letterGrade; }

    public void setLetterGrade(String letterGrade) { this.letterGrade = letterGrade; }

    @Override
    public String toString() {
        return student.getRegNo() + " - " + course.getCode() + " : " + letterGrade;
    }
}
