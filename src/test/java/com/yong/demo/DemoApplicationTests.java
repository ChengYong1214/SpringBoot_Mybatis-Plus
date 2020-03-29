package com.yong.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yong.demo.entity.Student;
import com.yong.demo.mapper.StudentMapper;
import com.yong.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    //模糊查询(条件构造器+查询)
    void contextLoads() {
        QueryWrapper<Student> wrapper=new QueryWrapper<Student>();
       //wrapper.like("name", "张");//全模糊
        //wrapper.likeLeft("name", "张");//左模糊
        //wrapper.likeRight("name", "张");//右模糊
        wrapper.notLike("name", "张");//查询不包括'张'的学生
        List<Student> list = studentMapper.selectList(wrapper);
        System.out.println(list.toString());
    }

    @Test
    //多条件判断，用点进行递进组合方式查询
    void contextLoads1(){
        QueryWrapper<Student> wrapper=new QueryWrapper<Student>();
        //1.查询地址，结果按age降序(orderByDesc),升序(orderByAsc)
        //wrapper.eq("address", "北京").orderByDesc("age");
        //2.模糊查询"张"，并且address为"北京"
        wrapper.like("name", "张").eq("address", "北京");
        List<Student> list = studentMapper.selectList(wrapper);
        System.out.println(list.toString());
    }

    @Test
    //分页
    void contextLoads2(){
        //1.创建Page对象，参数一：当前的页数；参数二：每页显示多少数据
        Page<Student> page=new Page<Student>(1,2);
        //2.创建IPage对象
        IPage<Student> iPage=studentMapper.selectPage(page,null);
        System.out.println("总数："+iPage.getTotal());
        System.out.println("总页数："+iPage.getPages());
        List<Student> list=iPage.getRecords();
        list.forEach(System.out::println);
    }

}
