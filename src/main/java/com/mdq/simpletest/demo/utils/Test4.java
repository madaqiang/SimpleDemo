package com.mdq.simpletest.demo.utils;

public class Test4 extends Test3 implements Test5{

    public void method1(){
        System.out.println("调用Test4===>method1()");
    }
//    public void method2(){
//        System.out.println("调用Test4===>method2()");
//    }

    public static void main(String args[]){
//    Test4 test = new Test4();
//        test.method1();
//    Test3 test3 = new Test3();
//    test3.method1();
//    Test3 test4 = new Test4();
//    test4.method1();

        Test4 test1 = new Test4();
        test1.method2();//调用Test3===>method2()

        Test3 test2 = new Test3();
        test2.method2();//调用Test3===>method2()

        Test3 test3 = new Test4();
        test3.method2();//调用Test3===>method2()

        Test5 test5 = new Test4();
        test5.method2();//调用Test3===>method2()

        Test5 test6 = new Test4();
        test6.method1();//调用Test4===>method1()

        Test3 test7 = new Test3(test6);
        test7.method2();//调用Test3===>method2()

    }
}
