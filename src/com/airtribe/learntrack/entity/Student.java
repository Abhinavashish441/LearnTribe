package com.airtribe.learntrack.entity;

public class Student extends Person{
	private int batch;
	private boolean active;
	
	public Student() {
	    super();
	}

	public Student(int id, String firstName, String lastName, String email,
	               int batch, boolean active) {
	    super(id, firstName, lastName, email);
	    this.batch = batch;
	    this.active = active;
	}

	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
