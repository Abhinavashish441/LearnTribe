package com.airtribe.learntrack.util;

public class InputValidator {

    // Validate integer input
    public static int parseInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    // Validate positive integer
    public static int validatePositiveInt(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        return number;
    }

    // Validate non-empty string
    public static String validateString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        return input.trim();
    }

    // Simple email validation
    public static String validateEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return email;
    }
}
