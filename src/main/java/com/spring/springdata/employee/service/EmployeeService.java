package com.spring.springdata.employee.service;

import com.spring.springdata.employee.model.Employee;

import java.math.BigDecimal;
import java.util.List;


public abstract class EmployeeService {

    public abstract void saveEmployee(Employee employee);

    public abstract Employee getEmployeeById(int id);

    public abstract List<Employee> getAllEmployee();

    public abstract void updateEmployee(int id, BigDecimal newSalary);

    public abstract void deleteEmployee(int id);

}
