package com.mdq.simpletest.demo.utils;

import java.util.ArrayList;
import java.util.List;

public class Test10 {


//    public static void  test2()
//    {
//        Test9.testList.add("c");
//    }

    public static void main(String[] args) {
        Test9.testList.add("c");
        Test9.testList.add("q");
        Test9.testList.remove("c");
        Test9.testList.stream().forEach(e -> {
            System.out.println(e);
        });
    }


//        Calendar calendar = Calendar.getInstance();
//        //calendar.setTime(new Date());
//        calendar.set(2019,7,21);
//        System.out.println(calendar.getTime());
//        //calendar.add(Calendar.MONTH,1);
//        Calendar calendarNew = Calendar.getInstance();
//        //calendarNew.set(2020,10,20);
//        Date now =new Date();
//        calendarNew.setTime(now);
//        System.out.println(now);
//        long ms = calendar.getTimeInMillis() - calendarNew.getTimeInMillis();
//        System.out.println(ms);
//        //long ms = 7948799980L;
//        System.out.println(Math.ceil((double) ms/(24*3600*1000)));
//        int day = (int)(Math.ceil((double)ms/(24*3600*1000)));
//        System.out.println(day);

//        Calendar cal = Calendar.getInstance();
//        cal.set(2019,10,20,0,0,0);
//       // cal.setTime(annualExpireDate);
//        cal.add(Calendar.MONTH,12);
//        System.out.println(cal.getTime());
//        Boolean flag = false;
//        testBoolean(flag);
//        System.out.println(flag);
       //int len = (1<<2)-1;
        //System.out.println(len);
//        System.out.println(Math.round(-1.5));
//        Integer a = null;
//        Integer b = null;
//        System.out.println(a==b);
//        //System.out.println(a.equals(b));
//        String c = "a";
//        String d = "a";
//        System.out.println(c==d);
//        System.out.println(c.equals(d));

//        String a = new String("ab"); // a 为一个引用
//        String b = new String("ab"); // b为另一个引用,对象的内容一样
//        String aa = "ab"; // 放在常量池中
//        String bb = "ab"; // 从常量池中查找
//        if (aa == bb) // true
//            System.out.println("aa==bb");
//        if (a == b) // false，非同一对象
//            System.out.println("a==b");
//        if (a.equals(b)) // true
//            System.out.println("true");
//        if (42 == 42.0) { // true
//            System.out.println("true");
//        }
//        //if(a == aa){//false
//            System.out.println(a==aa);
//        //}
//       // if(a.equals(aa)){//true
//            System.out.println(a.equals(aa));
//       // }

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //Date s = simpleDateFormat.parse("");
       // System.out.println(s);

//        String a = "c";
//        String e = a;
//        String b = "d";
//        //a= a+b;
//        System.out.println(a==e);

//        String a = "c";
//        String b =  new String("c");
//        String c = "c";
//        String d =  new String("c");
//        System.out.println(a==b);//false
//        System.out.println(a==c);//true
//        System.out.println(b==d);//false
//        int[] arr = new int[]{1,2,3,4,5};
//         final String a = arr.toString();
//        System.out.println("数组内容改变前的地址:"+a);
//        System.out.print("改变前的数组内容:");
//         for(int i=0;i<arr.length;i++){
//             System.out.print(arr[i]+",");
//             if(i==2 || i==3){
//                arr[i] = 6;
//             }
//         }
//        System.out.println();
//        System.out.print("改变后的数组内容:");
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+",");
//        }
//        System.out.println();
//        System.out.println("数组内容改变后的地址:"+arr.toString());
//        System.out.println("数组内容改变后a的地址:"+a);


}
