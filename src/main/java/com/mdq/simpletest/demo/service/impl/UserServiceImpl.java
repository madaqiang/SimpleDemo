package com.mdq.simpletest.demo.service.impl;

import com.mdq.simpletest.demo.mapper.UserMapper;
import com.mdq.simpletest.demo.model.User;
import com.mdq.simpletest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

     @Autowired
     UserMapper userMapper;
    @Override
    public User selectUser(int id) {
         return userMapper.selectUser(id);
     }

     @Override
    public List<User> selectAll(){
            return userMapper.selectAll();
     }
    @Override
    public List<User> selectByName(String name){
        return userMapper.selectByName(name);
    }
 }