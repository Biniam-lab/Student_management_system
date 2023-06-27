package com.studentmanagementsystem.StudentManagementSystem.Error;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
