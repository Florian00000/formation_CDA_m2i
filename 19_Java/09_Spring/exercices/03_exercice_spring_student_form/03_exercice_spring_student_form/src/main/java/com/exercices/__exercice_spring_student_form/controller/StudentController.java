package com.exercices.__exercice_spring_student_form.controller;

import com.exercices.__exercice_spring_student_form.model.Student;
import com.exercices.__exercice_spring_student_form.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentsList";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "studentForm";
        }else {
            System.out.println(student.toString());
            if (student.getId() == null) {
                studentService.addStudent(student);
            }else{
                studentService.updateStudent(student);
            }
            return "redirect:/detail/" + student.getId();
        }

    }

    @GetMapping("/detail/{id}")
    public String getStudentDetails(Model model, @PathVariable("id") UUID id) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "studentDetails";
    }

    @GetMapping("/filter")
    public String filterStudents(Model model, @RequestParam(name = "lastname", required = false) String lastname) {
        if (lastname != null) {
            model.addAttribute("students", studentService.getAllStudents().stream()
            .filter(student -> student.getLastname().equalsIgnoreCase(lastname))
                    .toList());
            return "studentsList";
        }else {
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(Model model, @PathVariable("id") UUID id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(Model model, @PathVariable("id") UUID id) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "studentForm";
    }
}
