package com.studentmanagementsystem.StudentManagementSystem.Service.Implementation;

import com.studentmanagementsystem.StudentManagementSystem.Entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.Repository.StudentRepository;
import com.studentmanagementsystem.StudentManagementSystem.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImplementation(StudentRepository studentRepository){
        super();
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getListOfAllStudents() {
        return studentRepository.findAll();
    }
}
