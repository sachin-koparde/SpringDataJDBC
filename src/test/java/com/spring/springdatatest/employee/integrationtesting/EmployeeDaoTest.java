package com.spring.springdatatest.employee.integrationtesting;

import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.dao.EmployeeDaoImpl;
import com.spring.springdata.employee.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Rollback
public class EmployeeDaoTest {

    @Test
    public void checkEmployeeCount() {

        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:schema.sql", "classpath:test-data.sql")
                .build();

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.setDataSource(dataSource);

        Assertions.assertEquals(3, employeeDao.getCountOfEmployees());
    }

    @Test
    @Transactional
    public void insertIntoLocalDatabaseTest() {

        Employee employee1 = Employee.createEmployee(45, "Shubham", new BigDecimal("93000.00"));

        System.out.println(employee1);

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.save(employee1);

        Employee employee = employeeDao.load(45);

        Assertions.assertEquals("Shubham", employee.getEmployeeName());
    }

}
