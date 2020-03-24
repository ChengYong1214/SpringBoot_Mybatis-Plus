package com.yong.demo.service.impl;

import com.yong.demo.entity.Student;
import com.yong.demo.mapper.StudentMapper;
import com.yong.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yong
 * @since 2020-03-24
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
