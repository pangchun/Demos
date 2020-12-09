package com.pangchun.jpacrud;

import com.pangchun.jpacrud.entity.Employee;
import com.pangchun.jpacrud.repository.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class JpacrudApplicationTests {

    @Autowired
    EmpRepository empRepository;

    @Test
    void contextLoads() {
        Date date = new Date();
        List list = new ArrayList<Employee>();
        for (int i = 0; i <24 ; i++) {
            Employee employee = new Employee();
            employee.setEmpNo(i);
            employee.setEmpName("张三"+i);
            employee.setGender("男");
            employee.setAge(21);
            employee.setBirth(date);
            employee.setEducation("大学本科");
            employee.setEmail("zhangSan@mail.com");
            list.add(employee);
        }
        empRepository.saveAll(list);
    }

}
