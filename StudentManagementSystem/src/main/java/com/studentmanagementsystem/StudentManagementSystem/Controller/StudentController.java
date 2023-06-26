package com.studentmanagementsystem.StudentManagementSystem.Controller;

import com.studentmanagementsystem.StudentManagementSystem.Entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listOfStudentsPage(Model model){
        model.addAttribute("students", studentService.getListOfAllStudents());
        return "students";
    }

    @GetMapping("/students/add")
    public String addStudentPage(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/students")
    public String addNewStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
