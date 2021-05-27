package com.spring.springdatatest.employee.integrationtesting;

//import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.dao.EmployeeDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

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

}
