package com.coderzoe.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

/**
 * @author yhs
 * @date 2020/5/18 17:32
 * @description
 */
public class MybatisUtil {
    private static ThreadLocal<SqlSession> sessionThreadLocal = new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MybatisUtil() {
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = sessionThreadLocal.get();
        if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
            //设置事务自动提交 默认是false
//            sqlSession = sqlSessionFactory.openSession(true);
        }
        return sqlSession;
    }

    public static void closeSqlSession(){
        SqlSession sqlSession = sessionThreadLocal.get();
        if(sqlSession!=null){
            sqlSession.close();
            sessionThreadLocal.remove();
        }
    }


    public static void main(String[] args) {
        System.out.println("hello");
        Connection connection = MybatisUtil.getSqlSession().getConnection();
        System.out.println(connection==null?"失败！！":"成功！！");
    }
}
