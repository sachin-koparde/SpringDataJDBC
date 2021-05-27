package com.spring.springdata.employee.controller;

import com.spring.springdata.employee.model.Employee;
import com.spring.springdata.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeService employeeService;

    public void init() {

        Employee employee = Employee.createEmployee(1, "Mahesh", 42000);
        employeeService.saveEmployee(employee);

        employee = Employee.createEmployee(2, "John", 15000);
        employeeService.saveEmployee(employee);

        employee = Employee.createEmployee(3, "Kiran", 34000);
        employeeService.saveEmployee(employee);

        LOGGER.info("Three employee data is inserted");

        employee = employeeService.getEmployeeById(1);

        LOGGER.info("Employee found by Id: " + employee);

        getAllEmployeeAndCheck();

        employeeService.updateEmployee(1, 56034);

        LOGGER.info("Salary updated: " + employeeService.getEmployeeById(1));

        employeeService.deleteEmployee(2);

        getAllEmployeeAndCheck();
    }

    public void getAllEmployeeAndCheck() {

        if(!employeeService.getAllEmployee().isEmpty()){
            LOGGER.info("All Employee: " + employeeService.getAllEmployee());
        }
        else {
            LOGGER.info("No Employee data Found");
        }

    }


}
