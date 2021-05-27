package com.spring.springdata.employee.dao;

import com.spring.springdata.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Component
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private final String QUERY_INSERT = "INSERT INTO employee(id, name, salary) VALUES(:id, :name, :salary)";
    private final String QUERY_FETCH_ALL = "SELECT * FROM employee";
    private final String QUERY_FETCH_BY_ID = "SELECT * FROM employee WHERE id = :id";
    private final String QUERY_UPDATE_SALARY = "UPDATE employee SET salary = :salary WHERE id = :id";
    private final String QUERY_DELETE = "DELETE FROM employee WHERE id = :id";
    private final String QUERY_GET_EMPLOYEE_COUNT =  "SELECT COUNT(*) FROM EMPLOYEE";

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void save(Employee employee) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", employee.getEmployeeId())
                .addValue("name", employee.getEmployeeName())
                .addValue("salary", employee.getEmployeeSalary());
        jdbcTemplate.update(QUERY_INSERT, parameterSource);

    }

    @Override
    public Employee load(int id) {

        List<Employee> employees = jdbcTemplate.query(QUERY_FETCH_BY_ID,
                new MapSqlParameterSource("id", id), (resultSet, i) -> toEmployee(resultSet));

        if(employees.size() == 1) {

            return employees.get(0);

        }

        return null;
    }

    @Override
    public void updateSalary(int id, BigDecimal newSalary) {

        jdbcTemplate.update(QUERY_UPDATE_SALARY,
                new MapSqlParameterSource("id", id).addValue("salary", newSalary));

    }

    @Override
    public void delete(int id) {

        jdbcTemplate.update(QUERY_DELETE, new MapSqlParameterSource("id", id));

    }

    @Override
    public List<Employee> loadAll() {

        return jdbcTemplate.query(QUERY_FETCH_ALL, (resultSet, i) -> {
            return toEmployee(resultSet);
        });

    }

    public int getCountOfEmployees() {

        return jdbcTemplate.queryForObject(QUERY_GET_EMPLOYEE_COUNT, (HashMap) null, Integer.class);

    }

    private Employee toEmployee(ResultSet resultSet) throws SQLException {

        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("id"));
        employee.setEmployeeName(resultSet.getString("name"));
        employee.setEmployeeSalary(resultSet.getBigDecimal("salary"));

        return employee;

    }
}
