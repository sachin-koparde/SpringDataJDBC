package com.spring.springdata.employee.dao;

import com.spring.springdata.employee.model.Employee;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    Employee load(int id);

    void updateSalary(int id, BigDecimal newSalary);

    void delete(int id);

    List<Employee> loadAll();

    void setDataSource(DataSource dataSource);

    int getCountOfEmployees();

}
