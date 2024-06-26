package com.exercices.__exercice_spring_student_form.service;

import com.exercices.__exercice_spring_student_form.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {
    private Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        student.setId(UUID.randomUUID());
        students.put(student.getId(), student);
    }

    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }

    public Student getStudent(UUID id) {
        return students.get(id);
    }

    public void deleteStudent(UUID id) {
        students.remove(id);
    }

    public void updateStudent(Student student) {
        students.replace(student.getId(), student);
    }
}
