package com.hsbc.bugreportapp.services;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SQLInjectionValidator {
	// Future Scope (Prototype code for SQL Injection Validator)
	
	
    // Regular expression pattern to match common SQL injection keywords
    private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile(
            "('|--|;|--\\s|\\s)|" +     // Common SQL injection keywords and symbols
            "(\\b(ALTER|CREATE|DELETE|DROP|EXEC(UTE)?|INSERT( +INTO)?|MERGE|SELECT|UPDATE)\\b)", 
            Pattern.CASE_INSENSITIVE);

    public static boolean isSafeInput(String userInput) {
        // Check if the input contains harmful SQL injection patterns
        Matcher matcher = SQL_INJECTION_PATTERN.matcher(userInput);
        return !matcher.find();
    }
}
