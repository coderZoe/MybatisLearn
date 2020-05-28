package com.coderzoe.dao;

import com.coderzoe.entity.Student;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/26 20:35
 * @description
 */
public interface StudentMapper {

    /**
     * @data: 2020/05/26 21:54
     * @author: yhs
     * @return: {@link List<Student> }
     * @description: 按查询 查询所有的学生和对应的老师信息
     */
    List<Student> findStudentsInfo();


    /**
     * @data: 2020/05/26 22:18
     * @author: yhs
     * @return: {@link List<Student> }
     * @description: 按结果 查询所有的学生和对应的老师信息
     */
    List<Student> findStudentsInfo2();
}
