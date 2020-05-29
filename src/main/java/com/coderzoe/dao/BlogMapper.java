package com.coderzoe.dao;

import com.coderzoe.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author yhs
 * @date 2020/5/29 19:27
 * @description
 */
public interface BlogMapper {

    int insertBlog(Blog blog);

    List<Blog> queryBlogIf(Map<String,Object> map);

    List<Blog> queryBlogChoose(Map<String,Object> map);

    int updateBlog(Map<String,Object> map);

    int insertBlog2(Map<String,Object> map);

    List<Blog> queryBlogForeach(List<String> idList);
}
