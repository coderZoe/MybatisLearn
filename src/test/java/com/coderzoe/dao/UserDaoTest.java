package com.coderzoe.dao;

import com.coderzoe.entity.User;
import com.coderzoe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/19 22:29
 * @description
 */
public class UserDaoTest {
    @Test
    public void test(){
        //step 1 获得SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //step 2 执行Sql
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        System.out.println(userList);
        //官方建议每次操作完 都需要关闭SqlSession
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User userById = mapper.getUserById((long) 1);
        System.out.println(userById);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //增删改需要提交事务
        mapper.insertUser(new User((long)4,"lili","111"));
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.update(new User(4L,"meimei","beautiful"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.delete(4);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }
}
