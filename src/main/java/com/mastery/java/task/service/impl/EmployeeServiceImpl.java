package com.mastery.java.task.service.impl;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        employeeDao.update(id, employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }


}

