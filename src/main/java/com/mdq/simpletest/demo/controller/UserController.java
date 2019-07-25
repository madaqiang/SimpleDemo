package com.mdq.simpletest.demo.controller;

import com.mdq.simpletest.demo.model.User;
import com.mdq.simpletest.demo.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showUser/{id}")
    public String selectUser (@PathVariable int id){
        return userService.selectUser(id).toString();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("userList",userService.selectAll());
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/selectByName")
    public List<User> selectByName(String name){
        return userService.selectByName(name);
    }
}