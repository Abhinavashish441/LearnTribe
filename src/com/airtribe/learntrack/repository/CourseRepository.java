package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseRepository {
	private ArrayList<Course> courses = new ArrayList<>();
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public Course getCourseById(int id) {
		for(Course course: courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		throw new EntityNotFoundException("Coursewith ID " + id + " not found");
	}
	
	public ArrayList<Course> getAllCourses() {
		return courses;
	}
	
	public void deactivateCourse(int id) {
		Course course = getCourseById(id);
		course.setActive(false);
		
	}

}
