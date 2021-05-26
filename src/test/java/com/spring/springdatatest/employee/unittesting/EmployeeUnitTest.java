package com.spring.springdatatest.employee.unittesting;

import com.spring.springdata.employee.dao.EmployeeDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class EmployeeUnitTest {

    private String QUERY_FETCH_EMPLOYEE_COUNT = "SELECT COUNT(*) FROM EMPLOYEE";

    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Starting Unit test");
    }

    @Test
    public void mockJdbcTemplateTest() {

        EmployeeDao employeeDao = new EmployeeDao();
        ReflectionTestUtils.setField(employeeDao, "jdbcTemplate", jdbcTemplate);
        when(jdbcTemplate.queryForObject(QUERY_FETCH_EMPLOYEE_COUNT, (HashMap) null, Integer.class))
                .thenReturn(4);

        Assertions.assertEquals(4, employeeDao.getCountOfEmployees());


    }


}
