package com.spring.springdata.employee.controller;

import com.spring.springdata.employee.model.Employee;
import com.spring.springdata.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Component
@Controller
public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeService employeeService;

    public void init() {

        Employee employee = Employee.createEmployee(5, "Ganesh", new BigDecimal("76589.00"));
        employeeService.saveEmployee(employee);

        employee = Employee.createEmployee(2, "John", new BigDecimal("23000.00"));
        employeeService.saveEmployee(employee);

        employee = Employee.createEmployee(3, "Kiran", new BigDecimal("34000.00"));
        employeeService.saveEmployee(employee);

        LOGGER.info("Three employee data is inserted");

        employee = employeeService.getEmployeeById(1);

        LOGGER.info("Employee found by Id: " + employee);

        getAllEmployeeAndCheck();

        employeeService.updateEmployee(1, new BigDecimal(24399));

        LOGGER.info("Salary updated: " + employeeService.getEmployeeById(1));

        employeeService.deleteEmployee(1);

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
