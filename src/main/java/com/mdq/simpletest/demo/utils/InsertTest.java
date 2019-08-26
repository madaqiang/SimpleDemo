package com.mdq.simpletest.demo.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.sql.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class InsertTest {
 
      private String url="jdbc:mysql://localhost:3306/usertest";
      private String user="root";
      private String password="root";
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        public Connection getConnect(){
            Connection con = null;
             try {
                Class.forName(JDBC_DRIVER);
                con= DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
             return con;
        }
        public void multiThreadImport( final int ThreadNum){
            final CountDownLatch cdl= new CountDownLatch(ThreadNum);//定义线程数量
            long startTime=System.currentTimeMillis();
            Date now = new Date(System.currentTimeMillis());
            for(int k=1;k<=ThreadNum;k++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Connection con=getConnect();
                        try {
                            //构造预处理statement
                            PreparedStatement pst = con.prepareStatement("insert into user(name,age,create_time,update_time) values (?,?,?,?)");
                           // Statement st=con.createStatement();
                            for(int i=1;i<=100000/ThreadNum;i++){
                                pst.setString(1,"test");
                                pst.setInt(2,10);
                                pst.setDate(3,now);
                                pst.setDate(4,now);
                                pst.addBatch();
                                //if(i%10000 == 0){
                                    pst.executeBatch();
                                    pst.clearBatch();
                                //}
                            }
                            cdl.countDown();    //执行完一个线程，递减1
                        } catch (Exception e) {
                        }finally{
                            try {
                                con.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
            try {
                cdl.await();    //前面线程没执行完，其他线程等待，不往下执行
                long spendtime=System.currentTimeMillis()-startTime;
                System.out.println( ThreadNum+"个线程花费时间:"+spendtime);
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().build();
    private static final ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(10);

    public void multiThreadImportTest(final int ThreadNum){
        final CountDownLatch cdl= new CountDownLatch(ThreadNum);//定义线程数量
        long startTime=System.currentTimeMillis();
        Date now = new Date(System.currentTimeMillis());
        Connection con=getConnect();
            try {
                    //构造预处理statement
                    PreparedStatement pst = con.prepareStatement("insert into user(name,age,create_time,update_time) values (?,?,?,?)");
                    executorService.scheduleAtFixedRate(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                for(int i=1;i<=100000;i++){
                                    pst.setString(1,"test"+i);
                                    pst.setInt(2,10);
                                    pst.setDate(3,now);
                                    pst.setDate(4,now);
                                    pst.addBatch();
                                    if(i%10000 == 0){
                                        pst.executeBatch();
                                        pst.clearBatch();
                                    }
                                }
                                //cdl.countDown();    //执行完一个线程，递减1
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    },0, 40, TimeUnit.MINUTES);
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                    }

            try {
                //cdl.await();    //前面线程没执行完，其他线程等待，不往下执行
                long spendtime=System.currentTimeMillis()-startTime;
                System.out.println( ThreadNum+"线程花费时间:"+spendtime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public static void main(String[] args) throws Exception {
            InsertTest ti=new InsertTest();
            ti.multiThreadImportTest(10);
        }
}