# 📚 LearnTrack – Student & Course Management System

**(Core Java | Console Application)**

---

## 📖 Project Overview

**LearnTrack** is a console-based **Student & Course Management System** developed using **Core Java**.
The project helps learners practice **Java fundamentals, Object-Oriented Programming (OOP), collections, and basic exception handling** through a real-world, menu-driven application.

The system allows an admin to manage:

* 👨‍🎓 **Students**
* 📘 **Courses**
* 📝 **Enrollments**

---

## ✨ Key Features

### 👨‍🎓 Student Management

* Add a new student
* View all students
* Search student by ID
* Deactivate a student (soft delete)

### 📘 Course Management

* Add a new course
* View all courses
* Activate / deactivate a course

### 📝 Enrollment Management

* Enroll a student in a course
* View enrollments for a student
* Update enrollment status:

  * `ACTIVE`
  * `COMPLETED`
  * `CANCELLED`

---

## 📂 Suggested Directory Structure

```
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
```

---

## 🧠 OOP Design & Concepts Used

### 🔐 Encapsulation

* All entity fields are declared `private`
* Fields are accessed using public getters and setters

### 🧬 Inheritance

```
Person
 └── Student
```

* `Person` contains common attributes (`id`, `firstName`, `lastName`, `email`)
* `Student` extends `Person`
* Demonstrates use of `super` constructors

### 🔄 Polymorphism

* Method overriding in child classes (e.g., display or utility methods)

### ⚙️ Static Members

* `IdGenerator` uses static counters and static methods
* Ensures consistent and unique ID generation across the application

---

## 📊 Class Relationship Diagram (High-Level)

```
Person
  └── Student

Student ---- Enrollment ---- Course
```

* One **Student** can have multiple **Enrollments**
* One **Course** can have multiple enrolled **Students**

---

## 🔁 Application Flow

1. `Main.java` displays menu options
2. User input is captured and validated
3. Service layer handles business logic
4. Repository layer manages in-memory data (`ArrayList`)
5. Results or error messages are displayed to the user

---

## ⚠️ Exception Handling

* Custom exception: `EntityNotFoundException`
* Optional: `InvalidInputException`
* `try-catch` blocks handle:

  * Invalid menu options
  * Incorrect data types
  * Non-existent student or course IDs
* Application handles errors gracefully without crashing

---

## ▶️ How to Compile & Run

### Using Terminal

```bash
javac com/airtribe/learntrack/Main.java
java com.airtribe.learntrack.Main
```

### Using an IDE

1. Import the project as a Java project
2. Ensure JDK is properly configured
3. Run `Main.java`

---

## 👥 Team Roles & Responsibilities (Example)

| Member | Responsibility                                     | Modules                                  |
| ------ | -------------------------------------------------- | ---------------------------------------- |
| 1      | Entities, constructors, inheritance, encapsulation | `entity/`                                |
| 2      | Services, business logic, menu flow                | `service/`, `Main.java`                  |
| 3      | Utilities, exceptions, documentation               | `util/`, `exception/`, `README`, `docs/` |

---

## ✅ Summary

**LearnTrack** is a foundational Core Java project aimed at building strong OOP thinking, clean architecture, and confidence in writing console-based applications.
Mastering this project prepares learners for more advanced Java topics in the future.


