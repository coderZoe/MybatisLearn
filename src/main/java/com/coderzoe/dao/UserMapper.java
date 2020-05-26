package com.coderzoe.dao;

import com.coderzoe.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author yhs
 * @date 2020/5/19 22:06
 * @description User的Dao层
 */
public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(long id);

    void insertUser(User use);

    void insertUser2(Map<String,Object> objectMap);

    void update(User user);

    void delete(long id);

    List<User> getUserLike(String value);

    List<User> findUserByPage(Map<String,Integer> map);

    /**
     * 使用注解开发
     */
    @Select("select * from user")
    List<User> getUsers();


    /**
     * @param
     * @param
     * @data: 2020/05/26 17:38
     * @author: yhs
     * @return: {@link User }
     * @description:  有多个参数 需要@Param注解
     *                @Param注解也可以用在xml中 换句话说 多个参数 可以在Mapper里写@param注解 然后在xml里使用注解 这样就不用传参map了
     *                sql语句中的#{id} #{name} 要求与@param注解的名字一样
     */
    @Select("select * from user where id = #{id} and name = #{name}")
    User getUserByIdAndName(@Param("id")long id,@Param("name")String name);

    @Insert("insert into user(id,name,password) values(#{id},#{name},#{password})")
    int insertUser3(User user);

    @Update("update user set name = #{name},password = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") long id);
}
