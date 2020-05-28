package com.coderzoe.dao;

import com.coderzoe.entity.NewTeacher;
import com.coderzoe.entity.Student;
import com.coderzoe.entity.Teacher;
import com.coderzoe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/26 21:20
 * @description
 */
public class TeacherAndStudentMapperTest {
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers();
        System.out.println(teachers);
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/26 22:11
     * @author: yhs
     * @return:
     * @description: 多对一查询 连表查询 多对一 多个学生对应一个老师
     *               Student类中包含一个老师类 老师是Student的一个外键
     *               在Sql查询中 正常sql是 select * from student,teacher where student.tid = teacher.id
     *               但Mybatis中 需要将数据库与entity对应 所以需要自己写一个resultmap 在Teacher属性中 是一个类 不再是单一属性
     *               需要用association标签 查询出student中的teacher 类似于子查询(嵌套查询) 更易于理解
     */
    @Test
    public void findStudentsInfo(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentsInfo = mapper.findStudentsInfo();
        System.out.println(studentsInfo);
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/28 20:54
     * @author: yhs
     * @return:
     * @description: 多对一查询 按结果关联查询 查出来后再映射 在association标签里嵌套完成teacher的映射
     */
    @Test
    public void findStudents2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentsInfo2 = mapper.findStudentsInfo2();
        System.out.println(studentsInfo2);
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/28 22:41
     * @author: yhs
     * @return:
     * @description: 一对多测试
     */
    @Test
    public void findNewTeachers(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<NewTeacher> newTeacher = mapper.getNewTeacher();
        System.out.println(newTeacher);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void findNewTeachers2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<NewTeacher> newTeacher2 = mapper.getNewTeacher2();
        System.out.println(newTeacher2);
    }


}
