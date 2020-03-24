package com.yong.demo.controller;


import com.yong.demo.entity.Student;
import com.yong.demo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yong
 * @since 2020-03-24
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/insertStu")
    @ResponseBody
    public String insertStu(Student student){
        studentService.save(student);
        return "添加成功！";
    }

    @RequestMapping("/selectStuById")
    @ResponseBody
    public String selectStuById(int id){
        Student student=studentService.getById(id);
        return student.toString();
    }

    @RequestMapping("/selectStuAll")
    public String selectStuAll(Model model){
        List<Student> stus=studentService.list(null);
        model.addAttribute("stus", stus);
        return "stuList";
    }

    @RequestMapping("/deleteStuById/{id}")
    public String deleteStuById(@PathVariable("id") int id){
        boolean b=studentService.removeById(id);
        return "redirect:/student/selectStuAll";
    }

    @RequestMapping("/updateStuById/{id}")
    public String updateStuById(@PathVariable("id") int id,Model model){
        Student student=studentService.getById(id);
        model.addAttribute("stu", student);
        return "update";
    }

    @RequestMapping("/updateUser")
    public String updateStuById(Student student){
        studentService.updateById(student);
        return "redirect:/student/selectStuAll";
    }
}

