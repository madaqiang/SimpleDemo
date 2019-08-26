package com.mdq.simpletest.demo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public  abstract class Test1 {

    public   int EachArray(int [] arr){
        return 1;
    }
    public   void EachArray1(int [] arr){

    }
    public static void main(String [] agrs)throws Exception{

//        Class clazz = Class.forName("com.chinaunicom.shanghai.microservice.chorserver.utils.Test1");
//        Constructor constructor = clazz.getConstructor();
//        Test1 test = (Test1)constructor.newInstance();
//        Method method = test.
                //获取字节码对象
       Class<Test1> clazz = (Class<Test1>) Class.forName("com.mdq.simpletest.demo.utils.Test1");
        //获取一个对象
        Constructor con =  clazz.getConstructor();
        Test1 m = (Test1) con.newInstance();
        String[] s = new String[]{"aa","bb"};
        //获取Method对象
        Method method = clazz.getMethod("EachArray", String[].class);
        //调用invoke方法来调用
        //method.invoke(m, new Object[]{s});
        method.invoke(m, (Object)s);

    }
}
