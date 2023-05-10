package com.i2f.springboot.service.impl;

import com.i2f.springboot.entity.User;
import com.i2f.springboot.mapper.UserMapper;
import com.i2f.springboot.repository.UserRepository;
import com.i2f.springboot.service.UserService;
import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 14:24 2022/6/7
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Autowired(required = true)
    UserRepository repository;
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    @Override
    public void doLogin(String name, String password) {
        System.out.println(Thread.currentThread().getName()+"service方法调用结束");
        User user = userMapper.selectByPrimaryKey(8);
        if(name.equals(user.getName()) && password.equals(user.getPassword())){
            //将用户信息存入redis
            redisTemplate.opsForValue().set("user",user);
            User user1 = (User) redisTemplate.opsForValue().get("user");
            System.out.println(user1.toString());
        }
        RedisTemplate redisTemplate = new RedisTemplate();
        TreeSet<String> set = new TreeSet();
        set.add("张三");
        set.add("张三1");
        set.add("王五");
        set.add("李四");

    }

    @Override
    public List<User> findBySex(Integer sex) {
        /*User user = new User();
        user.setId(11);
        Example<User> of = Example.of(user);*/
        //Optional<User> byId = repository.findById(sex);
        Optional<User> one = repository.findById(11);

        //Optional<User> one = repository.findOne(of);
        //List<Optional<User>> bySex = ;
        //Optional<User> xiaoxiao = repository.save(new User("xiaoxiao", "88"));
        /*List<User> collect = null;
        if(null != bySex && bySex.size() > 0){
             collect = bySex.stream().map(x -> x.get()).collect(Collectors.toList());
        }*/
        User user1 = one.get();
        String s = "";
        try{
            s = "222";
            int i = 1/0;
        }catch (Exception e){
            System.out.println("异常");
        }
        System.out.println(s);
        return new ArrayList<>();
    }

    @Override
    public synchronized void  updateSex(Integer id,String sex) {
        System.out.println(sex+"开始被执行了");
        User user = new User();
        user.setId(id);
        user.setSex(sex);
        userMapper.updateByPrimaryKeySelective(user);
        System.out.println(sex+"被执行了");
    }
}
