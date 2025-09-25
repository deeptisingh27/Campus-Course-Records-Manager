package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.List;

public interface CourseService {
    void addCourse(Course c);
    List<Course> getAll();
    Course findByCode(String code);
    void updateCourse(String code, String newTitle, String newInstructor);
    void deactivateCourse(String code);
}
