package com.mdq.simpletest.demo.utils;

import com.mdq.simpletest.demo.model.User;

import java.util.HashMap;
import java.util.Map;

public class Test8 {
    private static final int NOTICE_MAX_COUNT = 2;
    public static void main(String[] args) {
       // ThreadDemo threadDemo1 = new ThreadDemo();
       // ThreadDemo threadDemo2 = new ThreadDemo();

        //for(int i = 0 ;i<1000;i++){
           // threadDemo1.start();
           // threadDemo2.start();
       // }
//        Integer synCount = 2;
//        synCount = synCount == null ? Short.valueOf("1") : synCount == 2 ? NOTICE_MAX_COUNT:++synCount;
//        System.out.println(synCount);
        System.out.println(getpublic().get("user"));


    }
    public static Map<String,Object> getpublic (){
        User user =new User();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("user",user);
        return resultMap;
    }
}
