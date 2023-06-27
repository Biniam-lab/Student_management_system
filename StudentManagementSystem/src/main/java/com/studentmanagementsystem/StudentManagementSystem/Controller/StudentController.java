package com.studentmanagementsystem.StudentManagementSystem.Controller;

import com.studentmanagementsystem.StudentManagementSystem.Entity.Student;
import com.studentmanagementsystem.StudentManagementSystem.Error.StudentNotFoundException;
import com.studentmanagementsystem.StudentManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listOfStudentsPage(Model model){
        model.addAttribute("students", studentService.getStudentList());
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

    @GetMapping("/students/update/{studentId}")
    public String editStudentPage(@PathVariable int studentId, Model model) throws StudentNotFoundException {
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "update_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateExistingStudent(@PathVariable int studentId, @ModelAttribute("student") Student student) throws StudentNotFoundException {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        studentService.deleteStudentById(studentId);
        return "redirect:/students";
    }
}
