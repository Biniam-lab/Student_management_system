package com.studentmanagementsystem.StudentManagementSystem.Service;

import com.studentmanagementsystem.StudentManagementSystem.Entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.Error.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getStudentList();

    Student getStudentById(int studentId) throws StudentNotFoundException;

    void deleteStudentById(int studentId);

    Student updateStudent(Student student) throws StudentNotFoundException;

    Student getStudentByName(String departmentName);
}
