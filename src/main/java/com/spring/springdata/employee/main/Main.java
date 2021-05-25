package com.spring.springdata.employee.main;

import com.spring.springdata.employee.configure.AppConfig;
import com.spring.springdata.employee.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.getBean(EmployeeController.class).init();

    }

}
