package com.airtribe.learntrack.util;

public class IdGenerator {
	private static int studentIdGenerator = 1;
	private static int courseIdGenerator = 1;
	private static int enrollmentIdGenerator = 1;
	public static int getStudentIdGenerator() {
		return studentIdGenerator++;
	}
	public static int getCourseIdGenerator() {
		return courseIdGenerator++;
	}
	public static int getEnrollmentIdGenerator() {
		return enrollmentIdGenerator++;
	}
	
	
	

}
