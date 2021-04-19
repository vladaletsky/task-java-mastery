package com.mastery.java.task.service.impl;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.entity.Gender;
import com.mastery.java.task.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Employee Service Tests")
class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDao;
    private EmployeeService employeeService;

    private static Employee getFirstEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Joe");
        employee.setLastName("Dassin");
        employee.setJobTitle("Musician");
        employee.setDepartmentId(1);
        employee.setGender(Gender.MALE);
        return employee;
    }

    private static Employee getSecondEmployee() {
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setFirstName("John");
        employee.setLastName("Long");
        employee.setJobTitle("Developer");
        employee.setDepartmentId(2);
        employee.setGender(Gender.MALE);
        return employee;
    }

    private static Employee getThirdEmployee() {
        Employee employee = new Employee();
        employee.setId(3L);
        employee.setFirstName("Ledy");
        employee.setLastName("Gaga");
        employee.setJobTitle("Vocalist");
        employee.setDepartmentId(3);
        employee.setGender(Gender.FEMALE);
        return employee;
    }

    private static List<Employee> getEmployees() {
        return List.of(getFirstEmployee(), getSecondEmployee(), getThirdEmployee());
    }

    @BeforeEach
    void init() {
        employeeService = new EmployeeServiceImpl(employeeDao);
    }

    @Test
    @DisplayName("Test should return all employees")
    void testShouldReturnAllEmployees() {
        when(employeeDao.getAll()).thenReturn(getEmployees());
        List<Employee> employees = employeeService.getAllEmployee();
        assertEquals(employees, getEmployees());
        assertTrue(employees.contains(getFirstEmployee()));
        assertTrue(employees.contains(getThirdEmployee()));
        assertFalse(employees.contains(new Employee()));
        assertEquals(employees.size(), 3);
    }

    @Test
    @DisplayName("Test should return one employee")
    void testShouldReturnOneEmployee() {
        when(employeeDao.getAll()).thenReturn(List.of(getSecondEmployee()));
        List<Employee> employees = employeeService.getAllEmployee();
        assertEquals(employees, List.of(getSecondEmployee()));
        assertTrue(employees.contains(getSecondEmployee()));
        assertFalse(employees.contains(new Employee()));
        assertEquals(employees.size(), 1);
    }

    @Test
    @DisplayName("Test should delete employee")
    void testShouldDeleteEmployee(){
        when(employeeDao.getAll()).thenReturn(getEmployees());
        List<Employee> employees = employeeService.getAllEmployee();
        Employee employee = employees.get(0);
        employeeService.deleteEmployee(Math.toIntExact(employee.getId()));
        verify(employeeDao).delete(Math.toIntExact(employee.getId()));
    }
}