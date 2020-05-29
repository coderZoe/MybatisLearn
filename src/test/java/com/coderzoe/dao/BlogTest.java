package com.coderzoe.dao;

import com.coderzoe.entity.Blog;
import com.coderzoe.util.CreateUUId;
import com.coderzoe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author yhs
 * @date 2020/5/29 19:30
 * @description
 */
public class BlogTest {


    /**
     * @data: 2020/05/29 19:51
     * @author: yhs
     * @return:
     * @description: 插入数据
     */
    @Test
    public void insertBlog(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(CreateUUId.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("coderYin");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.insertBlog(blog);

        blog.setId(CreateUUId.getId());
        blog.setTitle("Java");
        blog.setAuthor("coderYin");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.insertBlog(blog);


        blog.setId(CreateUUId.getId());
        blog.setTitle("Spring");
        blog.setAuthor("coderYin");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.insertBlog(blog);

        blog.setId(CreateUUId.getId());
        blog.setTitle("JavaScript");
        blog.setAuthor("coderYin");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.insertBlog(blog);

        sqlSession.commit();

        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/29 20:06
     * @author: yhs
     * @return:
     * @description: 动态SQL if判断 where标签会去除无关的and 如果没有合适的语句 就去除where
     */
    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        List<Blog> blogs = mapper.queryBlogIf(map);
        System.out.println(blogs);

        map.put("title","Java");
        List<Blog> blogs1 = mapper.queryBlogIf(map);
        System.out.println(blogs1);
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/29 20:25
     * @author: yhs
     * @return:
     * @description: choose类似于switch case 只会选择一个条件执行 不会像if 主要有选择条件就往里加
     */
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        List<Blog> blogs = mapper.queryBlogChoose(map);
        System.out.println(blogs);

        map.put("title","Java");
        List<Blog> blogs1 = mapper.queryBlogChoose(map);
        System.out.println(blogs1);

        map.put("author","coderYin111");
        List<Blog> blogs2 = mapper.queryBlogChoose(map);
        System.out.println(blogs2);
    }

    /**
     * @data: 2020/05/29 21:18
     * @author: yhs
     * @return:
     * @description: set标签会自动前置set关键词 同时也会删除无关的逗号 set a = ?,b = ?,c = ?
     */
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id","3e24216d7b7145bcb5c42f30da5c0d59");
        map.put("title","程序员的自我修养");
        map.put("author","殷华盛");
        mapper.updateBlog(map);

        sqlSession.commit();

        MybatisUtil.closeSqlSession();
    }

    @Test
    public void insertBlog2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",CreateUUId.getId());
        map.put("author","殷华盛");
        mapper.insertBlog2(map);
        sqlSession.commit();

        MybatisUtil.closeSqlSession();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<String> idList = new ArrayList<>();
        idList.add("3e24216d7b7145bcb5c42f30da5c0d59");
        idList.add("bd64862c84ba4c3b8afa800ace342b14");
        idList.add("a82f3634cf5c4aa8b1bee5ab393a1bee");
        List<Blog> blogs = mapper.queryBlogForeach(idList);
        System.out.println(blogs);
    }
}
