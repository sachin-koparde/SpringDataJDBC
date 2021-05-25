package com.spring.springdata.employee.configure;

import com.spring.springdata.employee.controller.EmployeeController;
import com.spring.springdata.employee.dao.EmployeeDao;
import com.spring.springdata.employee.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDao();
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
