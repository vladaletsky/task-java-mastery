package com.mastery.java.task.dao;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.mapper.EmployeeRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeDao {

    private static final String GET_SQL = "SELECT * FROM employee";
    private static final String WHERE_BY_ID_SQL = " WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO employee VALUES(nextval ('employee_id_seq'), ?, ?, ?, ?, ?)";
    private static final String DELETE_SQL = "DELETE FROM employee WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, " +
            "job_title = ?, gender = ? WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public List<Employee> getAll() {
        return jdbcTemplate.query(GET_SQL, new EmployeeRowMapper());
    }

    public Employee getById(int id) {
        return jdbcTemplate.queryForObject(GET_SQL + WHERE_BY_ID_SQL, new EmployeeRowMapper(), id);
    }

    public void save(Employee employee) {
        jdbcTemplate.update(INSERT_SQL, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender().name());
    }

    public void update(int id, Employee employee) {
        jdbcTemplate.update(UPDATE_SQL, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender().name(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

}
