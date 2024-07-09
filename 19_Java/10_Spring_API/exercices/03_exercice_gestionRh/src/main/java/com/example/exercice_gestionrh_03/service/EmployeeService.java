package com.example.exercice_gestionrh_03.service;

import com.example.exercice_gestionrh_03.dto.employee.EmployeeDtoGet;
import com.example.exercice_gestionrh_03.dto.employee.EmployeeDtoPost;
import com.example.exercice_gestionrh_03.entity.Employee;
import com.example.exercice_gestionrh_03.exception.NotFoundException;
import com.example.exercice_gestionrh_03.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements BaseService<EmployeeDtoPost, EmployeeDtoGet> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDtoGet create(EmployeeDtoPost employeeDtoPost) {
        Employee employee = employeeDtoPost.toEmployee();
        employeeRepository.save(employee);
        return new EmployeeDtoGet(employee);
    }

    @Override
    public EmployeeDtoGet update(int id, EmployeeDtoPost employeeDtoPost) {
        Employee employee = employeeDtoPost.toEmployee();
        findEmployeeByIdInData(id);
        employee.setId(id);
        employeeRepository.save(employee);
        return new EmployeeDtoGet(employee);
    }

    @Override
    public boolean delete(int id) {
        Employee employee = findEmployeeByIdInData(id);
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public EmployeeDtoGet findById(int id) {
        Employee employee = findEmployeeByIdInData(id);
        return new EmployeeDtoGet(employee);
    }

    @Override
    public List<EmployeeDtoGet> findAll() {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        return employeeList.stream().map(EmployeeDtoGet::new).collect(Collectors.toList());
    }

    private Employee findEmployeeByIdInData(int id) {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
