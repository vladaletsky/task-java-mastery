package com.mastery.java.task.service;

import com.mastery.java.task.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
