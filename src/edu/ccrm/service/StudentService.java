package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student s);
    List<Student> getAll();
    Student findByRegNo(String regNo);
    void updateStudent(String regNo, String newName, String newEmail);
    void deactivateStudent(String regNo);
}
