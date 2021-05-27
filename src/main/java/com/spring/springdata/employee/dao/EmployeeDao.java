package com.spring.springdata.employee.dao;

import com.spring.springdata.employee.model.Employee;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDao {

    void save(Employee t);

    Employee load(int id);

    void updateSalary(int id, float newSalary);

    void delete(int id);

    List<Employee> loadAll();

    void setDataSource(DataSource dataSource);

    int getCountOfEmployees();

}
