package com.i2f.springboot.service;

import com.i2f.springboot.entity.User;

import java.util.List;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 14:24 2022/6/7
 */
public interface UserService {
     void doLogin(String name, String password);

    List<User> findBySex(Integer sex);

    void updateSex(Integer id, String sex);

}
