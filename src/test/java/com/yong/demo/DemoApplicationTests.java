package com.yong.demo;

import com.yong.demo.entity.Student;
import com.yong.demo.mapper.StudentMapper;
import com.yong.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
private StudentMapper studentMapper;
    @Test
    void contextLoads() {
        Student student=new Student();
        student.setName("张三");
        student.setAge(12);
        student.setAddress("南京");

        studentMapper.insert(student);
    }

}
