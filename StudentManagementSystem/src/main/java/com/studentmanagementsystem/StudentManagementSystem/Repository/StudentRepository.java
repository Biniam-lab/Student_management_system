package com.studentmanagementsystem.StudentManagementSystem.Repository;

import com.studentmanagementsystem.StudentManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
