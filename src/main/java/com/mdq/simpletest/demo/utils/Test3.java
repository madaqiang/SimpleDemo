package com.mdq.simpletest.demo.utils;

public class Test3 {
    Test5 test5;

    public Test3(Test5 test5){
        super();
        this.test5 = test5;
    }
    public Test3(){
        super();
    }
    public void method1(){
        System.out.println("调用Test3===>method1()");
    }
    public void method2(){
        System.out.println("调用Test3===>method2()");
    }
}
