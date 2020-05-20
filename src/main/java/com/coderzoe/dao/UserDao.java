package com.coderzoe.dao;

import com.coderzoe.entity.User;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/19 22:06
 * @description User的Dao层
 */
public interface UserDao {
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(long id);

    void insertUser(User use);

    void update(User user);

    void delete(long id);
}
