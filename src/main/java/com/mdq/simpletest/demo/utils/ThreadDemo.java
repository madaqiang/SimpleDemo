package com.mdq.simpletest.demo.utils;

public class ThreadDemo extends Thread{
    int a=0;
    @Override
    public void run() {
        for(int i = 0 ;i<1000;i++) {

            System.out.println("当前线程为："+this.currentThread().getName()+"a当前值为：" + a++);
        }
    }
}
