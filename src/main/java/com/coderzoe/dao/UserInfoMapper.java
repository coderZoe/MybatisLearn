package com.coderzoe.dao;

import com.coderzoe.entity.UserInfo;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/22 20:59
 * @description
 */
public interface UserInfoMapper {
    UserInfo getUserInfoById(int id);

    List<UserInfo> getAllUserInfo();
}
