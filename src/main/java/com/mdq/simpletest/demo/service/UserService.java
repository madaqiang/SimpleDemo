package com.mdq.simpletest.demo.service;

import com.mdq.simpletest.demo.model.User;

import java.util.List;

public interface UserService {

    public User selectUser(int id);

    public List<User> selectAll();

    public List<User> selectByName(String name);

    public int insertUser(User user);


}