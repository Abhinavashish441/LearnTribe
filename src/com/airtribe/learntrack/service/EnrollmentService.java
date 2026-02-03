package com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
	private StudentService studentService;
	private CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.enrollmentRepository = new EnrollmentRepository();
        this.studentService = studentService;
        this.courseService = courseService;
    }


	public void enrollStudentInCourse(int studentId, int courseId) {
        Student student = studentRepository.getStudentById(studentId);
        Course course = courseRepository.getCourseById(courseId);

        Enrollment enrollment = new Enrollment();
        enrollment.setId(IdGenerator.getEnrollmentIdGenerator());
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollment.setStatus(EnrollmentStatus.ACTIVE.name());

        enrollmentRepository.addEnrollment(enrollment);
    }

    public ArrayList<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return enrollmentRepository.getEnrollmentByStudentId(studentId);
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {
        enrollmentRepository.updateEnrollmentStatus(enrollmentId, status);
    }
}
