📚 LearnTrack – Student & Course Management System

(Core Java | Console Application)

Project Overview

LearnTrack is a console-based Student & Course Management System developed using Core Java.
The project is designed to help learners practice Java fundamentals, Object-Oriented Programming (OOP), collections, and basic exception handling through a real-world, menu-driven application.

The system allows an admin to manage:

👨‍🎓 Students

📘 Courses

📝 Enrollments

This project intentionally avoids advanced Java topics (Streams, Concurrency, Frameworks) to keep the focus on strong fundamentals and clean code design.

Core Objectives

By completing this project, learners will gain hands-on experience with:

Java setup and execution (JDK, JVM basics)

Core Java syntax and control flow

Object-Oriented Programming concepts

Layered application design

In-memory data management using ArrayList

Custom and basic exception handling

Writing clean, readable, and modular code

Key Features
Student Management

Add a new student

View all students

Search student by ID

Deactivate a student (soft delete)

Course Management

Add a new course

View all courses

Activate / deactivate a course

Enrollment Management

Enroll a student in a course

View enrollments for a student

Update enrollment status:

ACTIVE

COMPLETED

CANCELLED

Suggested Directory Structure
src/
└── com/
    └── airtribe/
        └── learntrack/
            ├── Main.java                 // Application entry point & menu
            │
            ├── entity/                  // Core domain models
            │   ├── Person.java
            │   ├── Student.java
            │   ├── Course.java
            │   └── Enrollment.java
            │
            ├── repository/              // In-memory data storage
            │   ├── StudentRepository.java
            │   ├── CourseRepository.java
            │   └── EnrollmentRepository.java
            │
            ├── service/                 // Business logic layer
            │   ├── StudentService.java
            │   ├── CourseService.java
            │   └── EnrollmentService.java
            │
            ├── exception/               // Custom exceptions
            │   ├── EntityNotFoundException.java
            │   └── InvalidInputException.java
            │
            ├── util/                    // Utility/helper classes
            │   ├── IdGenerator.java
            │   └── InputValidator.java
            │
            ├── constants/               // Application-wide constants
            │   ├── MenuOptions.java
            │   └── AppConstants.java
            │
            └── enums/                   // Fixed states / values
                ├── EnrollmentStatus.java
                └── CourseStatus.java

OOP Design & Concepts Used
Encapsulation

All entity fields are declared private

Accessed via public getters and setters

Inheritance
Person
 └── Student


Person contains common attributes (id, firstName, lastName, email)

Student extends Person

Demonstrates use of super constructors

Polymorphism

Method overriding (e.g., display or utility methods in subclasses)

Static Members

IdGenerator uses static counters and methods to generate unique IDs

Ensures consistent ID creation across the application

Class Relationship Diagram (High-Level)
Person
  └── Student

Student ---- Enrollment ---- Course


One student can have multiple enrollments

One course can have multiple enrolled students

Application Flow

Main.java displays menu options

User input is validated

Service layer processes business logic

Repository layer manages in-memory data

Results or error messages are shown to the user

Exception Handling

Custom exception: EntityNotFoundException

Optional: InvalidInputException

try-catch blocks used to handle:

Invalid menu options

Incorrect data types

Non-existent IDs

Application handles errors gracefully without crashing

How to Compile & Run
Using Terminal
javac com/airtribe/learntrack/Main.java
java com.airtribe.learntrack.Main

Using an IDE

Import project as a Java project

Ensure JDK is configured

Run Main.java

Team Roles & Responsibilities (Example)
Member	Responsibility	Modules
1	Entities, constructors, inheritance, encapsulation	entity/
2	Services, business logic, menu flow	service/, Main.java
3	Utilities, exceptions, documentation	util/, exception/, README, docs/
