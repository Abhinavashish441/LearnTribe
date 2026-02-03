package com.airtribe.learntrack.service;

import java.util.ArrayList;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService() {
        this.courseRepository = new CourseRepository();
    }

    public void addNewCourse(String courseName, String description, int durationInWeeks, boolean b) {
        Course course = new Course();
        course.setId(IdGenerator.getCourseIdGenerator());
        course.setCourseName(courseName);
        course.setDescription(description);
        course.setDurationInWeeks(durationInWeeks);
        course.setActive(true);

        courseRepository.addCourse(course);
    }

    public ArrayList<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course findCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    public void deactivateCourse(int id) {
        Course course = courseRepository.getCourseById(id);
        course.setActive(false);
    }

    public void activateCourse(int id) {
        Course course = courseRepository.getCourseById(id);
        course.setActive(true);
    }

    public void toggleCourseActive(int courseId) {
        Course course = courseRepository.getCourseById(courseId);
        course.setActive(!course.isActive());
    }

}
