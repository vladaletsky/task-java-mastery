package com.mastery.java.task.rest;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }
}
