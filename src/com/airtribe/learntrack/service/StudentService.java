package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class StudentService {
	private StudentRepository studentRepository;
	public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    public void addNewStudent(String firstName, String lastName, String email, int batch) {
        Student student = new Student();
        student.setId(IdGenerator.getStudentIdGenerator());
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setBatch(batch);
        student.setActive(true);

        studentRepository.addStudent(student);
    }
	
	public ArrayList<Student> getAllStudent(){
		return studentRepository.getAllStudents();
	}
	
	public Student findStudentById(int id) {
		return studentRepository.getStudentById(id);
	}
	
	public void deactivateStudent(int id) {
		studentRepository.deactivateStudent(id);
	}

}
