package edu.ccrm.service;

import edu.ccrm.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student s) {
        students.add(s);
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student findByRegNo(String regNo) {
        if (regNo == null) return null;
        for (Student s : students) {
            if (regNo.equalsIgnoreCase(s.getRegNo())) return s;
        }
        return null;
    }

    @Override
    public void updateStudent(String regNo, String newName, String newEmail) {
        Student s = findByRegNo(regNo);
        if (s != null) {
            if (newName != null && !newName.isBlank()) s.setFullName(newName);
            if (newEmail != null && !newEmail.isBlank()) s.setEmail(newEmail);
        }
    }

    @Override
    public void deactivateStudent(String regNo) {
        Student s = findByRegNo(regNo);
        if (s != null) s.deactivate();
    }
}
