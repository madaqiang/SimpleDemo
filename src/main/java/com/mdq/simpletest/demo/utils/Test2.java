package com.mdq.simpletest.demo.utils;

import com.google.common.collect.Lists;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Test2 extends Test1 {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static String defaultExpiryDate = "2037-01-01";
    public static void main(String [] agrs)throws Exception{
        //System.out.println(sdf.format(new Date()).compareTo(""));
       // System.out.println(JSONObject.toJSONString(""));
        System.out.println(sdf.parse(defaultExpiryDate));
//        Map<String,String> map = new HashMap<>();
//        map.put("1","1");
//        map.put("2","2");
//        map.put("3","3");
//        map.put("4","4");
//        String value = map.get("5");
//        System.out.println(value);
//        String str = "a";
//        String str1 = new String("a");
//        String str2 = new String("a");

//        System.out.println(str.equals(str1));//true
//        System.out.println(str==str1);//false
//        System.out.println(str1.equals(str2));//true
//        System.out.println(str1==str2);//false

        //int[] ac = new int[]{1,2,3,4,5,6};
//        Test2 test2 = new Test2();
//        System.out.println(test2.EachArray(ac));
//        int[] ab = new int[10];
//        System.arraycopy(ac,1,ab,0,ac.length-1);
//        Arrays.stream(ab).forEach(a-> System.out.print(a));
    }
    public   void test(){};

    public int EachArray(int [] arr){
        return 0;
    }


}
