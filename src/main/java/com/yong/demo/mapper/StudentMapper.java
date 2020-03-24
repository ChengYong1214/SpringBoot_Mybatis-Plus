package com.yong.demo.mapper;

import com.yong.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yong
 * @since 2020-03-24
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
