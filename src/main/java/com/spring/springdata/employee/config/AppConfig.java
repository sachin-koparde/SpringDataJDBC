package com.spring.springdata.employee.config;

import com.spring.springdata.employee.controller.EmployeeController;
//import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.dao.EmployeeDaoImpl;
import com.spring.springdata.employee.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeServiceImpl employeeService() {
        return new EmployeeServiceImpl();
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl();
    }

    @Bean
    public EmployeeController employeeController() {
        return new EmployeeController();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(oracle.jdbc.pool.OracleDataSource.class.getName());
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("system");
        dataSource.setPassword("root");
        return dataSource;
    }

}
