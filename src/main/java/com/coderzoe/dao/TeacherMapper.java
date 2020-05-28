package com.coderzoe.dao;

import com.coderzoe.entity.NewTeacher;
import com.coderzoe.entity.Teacher;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/26 20:35
 * @description
 */
public interface TeacherMapper {
    List<Teacher> getTeachers();

    List<NewTeacher> getNewTeacher();

    List<NewTeacher> getNewTeacher2();
}
