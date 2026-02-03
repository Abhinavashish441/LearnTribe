package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentRepository {
	private ArrayList<Student> students = new ArrayList<>();
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public Student getStudentById(int id) {
		for(Student student: students) {
			if(student.getId()==id) {
				return student;
			}
		}
		throw new EntityNotFoundException("Student with ID " + id + " not found");
	}
	
	public ArrayList<Student> getAllStudents() {
		return students;
	}
	
	public void deactivateStudent(int id) {
		Student student = getStudentById(id);
		student.setActive(false);
		
	}

}
