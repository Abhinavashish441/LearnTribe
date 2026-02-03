package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentRepository {
	private ArrayList<Enrollment> enrollments = new ArrayList<>();
	
	public void addEnrollment(Enrollment enrollment) {
		enrollments.add(enrollment);
	}
	
	public Enrollment getEnrollmentById(int id) {
		for(Enrollment enrollment: enrollments) {
			if(enrollment.getId()==id) {
				return enrollment;
			}
		}
		throw new EntityNotFoundException("Enrollment with ID " + id + " not found");
	}
	
	public ArrayList<Enrollment> getEnrollmentByStudentId(int studentId) {
	    ArrayList<Enrollment> result = new ArrayList<>();

	    for (Enrollment enrollment : enrollments) {
	        if (enrollment.getStudentId() == studentId) {
	            result.add(enrollment);
	        }
	    }

	    if (result.isEmpty()) {
	        throw new EntityNotFoundException(
	            "No enrollments found for student ID " + studentId
	        );
	    }

	    return result;
	}
	
	public void updateEnrollmentStatus(int id, EnrollmentStatus status) {
		Enrollment enrollment = getEnrollmentById(id);
		enrollment.setStatus(status);
	}

}
