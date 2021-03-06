package com.spring.springdata.employee;

import com.spring.springdata.employee.config.AppConfig;
import com.spring.springdata.employee.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.getBean(EmployeeController.class).init();

    }

}
