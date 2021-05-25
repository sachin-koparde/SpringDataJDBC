package com.spring.springdata.employee.service;

import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.load(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeDao.loadAll();
    }

    public void updateEmployee(int id, float newSalary) {
        employeeDao.updateSalary(id, newSalary);
    }

    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }

}
