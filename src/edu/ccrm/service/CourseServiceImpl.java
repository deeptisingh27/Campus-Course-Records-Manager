package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private List<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course c) {
        courses.add(c);
    }

    @Override
    public List<Course> getAll() {
        return courses;
    }

    @Override
    public Course findByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCourse(String code, String newTitle, String newInstructor) {
        Course c = findByCode(code);
        if (c != null) {
            c.setTitle(newTitle);
            c.setInstructor(newInstructor);
        }
    }

    @Override
    public void deactivateCourse(String code) {
        Course c = findByCode(code);
        if (c != null) {
            c.deactivate();
        }
    }
}
