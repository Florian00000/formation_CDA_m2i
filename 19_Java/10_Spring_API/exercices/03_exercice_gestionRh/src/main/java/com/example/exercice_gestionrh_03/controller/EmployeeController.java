package com.example.exercice_gestionrh_03.controller;

import com.example.exercice_gestionrh_03.dto.employee.EmployeeDtoGet;
import com.example.exercice_gestionrh_03.dto.employee.EmployeeDtoPost;
import com.example.exercice_gestionrh_03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeDtoGet>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDtoGet> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDtoGet> addEmployee(@RequestBody EmployeeDtoPost employeeDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employeeDtoPost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDtoGet> updateEmployee(@PathVariable int id, @RequestBody EmployeeDtoPost employeeDtoPost) {
        return ResponseEntity.ok(employeeService.update(id, employeeDtoPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
