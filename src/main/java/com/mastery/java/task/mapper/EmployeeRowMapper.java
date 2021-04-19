package com.mastery.java.task.mapper;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.entity.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setJobTitle(resultSet.getString("job_title"));
        employee.setDepartmentId(resultSet.getInt("department_id"));
        employee.setGender(Gender.valueOf(resultSet.getString("gender")));
        return employee;
    }
}
