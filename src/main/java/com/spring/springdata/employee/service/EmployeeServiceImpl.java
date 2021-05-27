package com.spring.springdata.employee.service;

import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.load(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.loadAll();
    }

    @Override
    public void updateEmployee(int id, float newSalary) {
        employeeDao.updateSalary(id, newSalary);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }

}
