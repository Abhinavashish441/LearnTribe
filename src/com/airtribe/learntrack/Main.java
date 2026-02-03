package com.airtribe.learntrack;

import java.util.ArrayList;
import java.util.Scanner;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

        System.out.println(AppConstants.WELCOME_MESSAGE);

        boolean exit = false;
        while (!exit) {
            showMainMenu();
            int choice = readInt();
            switch (choice) {
                case MenuOptions.MAIN_STUDENT_MANAGEMENT:
                    studentMenu(studentService);
                    break;
                case MenuOptions.MAIN_COURSE_MANAGEMENT:
                    courseMenu(courseService);
                    break;
                case MenuOptions.MAIN_ENROLLMENT_MANAGEMENT:
                    enrollmentMenu(enrollmentService);
                    break;
                case MenuOptions.MAIN_EXIT:
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_OPTION);
            }
        }
    }

    // ---------- MAIN MENU ----------
    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println(MenuOptions.MAIN_STUDENT_MANAGEMENT + ". Student Management");
        System.out.println(MenuOptions.MAIN_COURSE_MANAGEMENT + ". Course Management");
        System.out.println(MenuOptions.MAIN_ENROLLMENT_MANAGEMENT + ". Enrollment Management");
        System.out.println(MenuOptions.MAIN_EXIT + ". Exit");
        System.out.print("Choose an option: ");
    }

    // ---------- STUDENT MENU ----------
    private static void studentMenu(StudentService studentService) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Menu ---");
            System.out.println(MenuOptions.STUDENT_ADD + ". Add Student");
            System.out.println(MenuOptions.STUDENT_VIEW_ALL + ". View All Students");
            System.out.println(MenuOptions.STUDENT_SEARCH + ". Search Student by ID");
            System.out.println(MenuOptions.STUDENT_DEACTIVATE + ". Deactivate Student");
            System.out.println(MenuOptions.STUDENT_BACK + ". Back");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case MenuOptions.STUDENT_ADD:
                    addStudent(studentService);
                    break;
                case MenuOptions.STUDENT_VIEW_ALL:
                    viewAllStudents(studentService);
                    break;
                case MenuOptions.STUDENT_SEARCH:
                    searchStudent(studentService);
                    break;
                case MenuOptions.STUDENT_DEACTIVATE:
                    deactivateStudent(studentService);
                    break;
                case MenuOptions.STUDENT_BACK:
                    back = true;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_OPTION);
            }
        }
    }

    private static void addStudent(StudentService studentService) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.print("Enter Email: ");
        String email = scanner.next();
        System.out.print("Enter Batch Number: ");
        int batch = readInt();
        studentService.addNewStudent(firstName, lastName, email, batch);
        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents(StudentService studentService) {
        ArrayList<Student> students = studentService.getAllStudent();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getFirstName() + " " + s.getLastName() + ", Email: " + s.getEmail() + ", Batch: " + s.getBatch() + ", Active: " + s.isActive());
        }
    }

    private static void searchStudent(StudentService studentService) {
        System.out.print("Enter Student ID: ");
        int id = readInt();
        try {
            Student s = studentService.findStudentById(id);
            System.out.println("ID: " + s.getId() + ", Name: " + s.getFirstName() + " " + s.getLastName() + ", Email: " + s.getEmail() + ", Batch: " + s.getBatch() + ", Active: " + s.isActive());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deactivateStudent(StudentService studentService) {
        System.out.print("Enter Student ID to deactivate: ");
        int id = readInt();
        try {
            studentService.deactivateStudent(id);
            System.out.println("Student deactivated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ---------- COURSE MENU ----------
    private static void courseMenu(CourseService courseService) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Menu ---");
            System.out.println(MenuOptions.COURSE_ADD + ". Add Course");
            System.out.println(MenuOptions.COURSE_VIEW_ALL + ". View All Courses");
            System.out.println(MenuOptions.COURSE_ACTIVATE_DEACTIVATE + ". Activate/Deactivate Course");
            System.out.println(MenuOptions.COURSE_BACK + ". Back");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case MenuOptions.COURSE_ADD:
                    addCourse(courseService);
                    break;
                case MenuOptions.COURSE_VIEW_ALL:
                    viewAllCourses(courseService);
                    break;
                case MenuOptions.COURSE_ACTIVATE_DEACTIVATE:
                    toggleCourse(courseService);
                    break;
                case MenuOptions.COURSE_BACK:
                    back = true;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_OPTION);
            }
        }
    }

    private static void addCourse(CourseService courseService) {
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course Description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter Duration in Weeks: ");
        int duration = readInt();
        courseService.addNewCourse(name, desc, duration, true);
        System.out.println("Course added successfully!");
    }

    private static void viewAllCourses(CourseService courseService) {
        ArrayList<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course c : courses) {
            System.out.println("ID: " + c.getId() + ", Name: " + c.getCourseName() + ", Description: " + c.getDescription() + ", Duration: " + c.getDurationInWeeks() + " weeks, Active: " + c.isActive());
        }
    }

    private static void toggleCourse(CourseService courseService) {
        System.out.print("Enter Course ID to activate/deactivate: ");
        int id = readInt();
        try {
            courseService.toggleCourseActive(id);
            System.out.println("Course status updated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ---------- ENROLLMENT MENU ----------
    private static void enrollmentMenu(EnrollmentService enrollmentService) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Enrollment Menu ---");
            System.out.println(MenuOptions.ENROLL_STUDENT + ". Enroll Student in Course");
            System.out.println(MenuOptions.ENROLL_VIEW_BY_STUDENT + ". View Enrollments by Student");
            System.out.println(MenuOptions.ENROLL_UPDATE_STATUS + ". Update Enrollment Status");
            System.out.println(MenuOptions.ENROLL_BACK + ". Back");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case MenuOptions.ENROLL_STUDENT:
                    enrollStudent(enrollmentService);
                    break;
                case MenuOptions.ENROLL_VIEW_BY_STUDENT:
                    viewEnrollments(enrollmentService);
                    break;
                case MenuOptions.ENROLL_UPDATE_STATUS:
                    updateEnrollmentStatus(enrollmentService);
                    break;
                case MenuOptions.ENROLL_BACK:
                    back = true;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_OPTION);
            }
        }
    }

    private static void enrollStudent(EnrollmentService enrollmentService) {
        System.out.print("Enter Student ID: ");
        int studentId = readInt();
        System.out.print("Enter Course ID: ");
        int courseId = readInt();
        try {
            enrollmentService.enrollStudentInCourse(studentId, courseId);
            System.out.println("Student enrolled successfully!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewEnrollments(EnrollmentService enrollmentService) {
        System.out.print("Enter Student ID: ");
        int studentId = readInt();
        try {
            ArrayList<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
            for (Enrollment e : enrollments) {
                System.out.println("Enrollment ID: " + e.getId() + ", Course ID: " + e.getCourseId() + ", Status: " + e.getStatus() + ", Date: " + e.getEnrollmentDate());
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateEnrollmentStatus(EnrollmentService enrollmentService) {
        System.out.print("Enter Enrollment ID: ");
        int enrollmentId = readInt();
        System.out.print("Enter new status (ACTIVE, COMPLETED, CANCELLED): ");
        String statusStr = scanner.next().toUpperCase();
        try {
            EnrollmentStatus status = EnrollmentStatus.valueOf(statusStr);
            enrollmentService.updateEnrollmentStatus(enrollmentId, status);
            System.out.println("Enrollment status updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status value!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ---------- HELPER ----------
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
