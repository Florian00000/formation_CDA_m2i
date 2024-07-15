package com.example.exercice_gestionrh_03.service;

import com.example.exercice_gestionrh_03.dto.absence.AbsenceDtoGet;
import com.example.exercice_gestionrh_03.dto.absence.AbsenceDtoPost;
import com.example.exercice_gestionrh_03.dto.employee.EmployeeDtoGet;
import com.example.exercice_gestionrh_03.dto.employee.EmployeeDtoPost;
import com.example.exercice_gestionrh_03.entity.Absence;
import com.example.exercice_gestionrh_03.entity.Employee;
import com.example.exercice_gestionrh_03.exception.NotFoundException;
import com.example.exercice_gestionrh_03.repository.AbsenceRepository;
import com.example.exercice_gestionrh_03.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements BaseService<EmployeeDtoPost, EmployeeDtoGet> {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AbsenceRepository absenceRepository;

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

    //Absences
    public EmployeeDtoGet addAbsence(int  id, AbsenceDtoPost absenceDtoPost) {
        Employee employee = findEmployeeByIdInData(id);
        Absence absence = absenceDtoPost.toAbsence();
        absence.setEmployee(employee);
        absenceRepository.save(absence);
        return new EmployeeDtoGet(employee);
    }

    public List<AbsenceDtoGet> getAllAbsence() {
        List<Absence> absenceList = (List<Absence>) absenceRepository.findAll();
        return absenceList.stream().map(AbsenceDtoGet::new).collect(Collectors.toList());
    }

    public List<AbsenceDtoGet> getAllAbsenceByEmployeeId(int employeeId) {
        Employee employee = findEmployeeByIdInData(employeeId);
        List<Absence> absenceList = absenceRepository.findAllByEmployee(employee);
        return absenceList.stream().map(AbsenceDtoGet::new).collect(Collectors.toList());
    }

}