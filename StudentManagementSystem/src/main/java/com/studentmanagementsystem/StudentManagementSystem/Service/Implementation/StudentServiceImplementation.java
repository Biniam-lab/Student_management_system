package com.studentmanagementsystem.StudentManagementSystem.Service.Implementation;

import com.studentmanagementsystem.StudentManagementSystem.Entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.Error.StudentNotFoundException;
import com.studentmanagementsystem.StudentManagementSystem.Repository.StudentRepository;
import com.studentmanagementsystem.StudentManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int studentId) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(studentId);

        if(!student.isPresent()) {
            throw new StudentNotFoundException("Student Not Available");
        }
        return  student.get();
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student) throws StudentNotFoundException {
        Student existing = getStudentById(student.getStudentId());

        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setGender(student.getGender());
        existing.setEmail(student.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentByName(String departmentName) {
        return null;
    }
}
