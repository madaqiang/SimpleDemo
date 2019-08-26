package com.mdq.simpletest.demo.utils;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySQLDemo {
 
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/usertest";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
 
    public static void main(String[] args) {
        Connection conn = null;
        // Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //test1(conn);
            exec3(conn);
            //exec4(conn);
            // 执行查询
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT id, name, url FROM websites";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                int id  = rs.getInt("id");
//                String name = rs.getString("name");
//                String url = rs.getString("url");
//
//                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", 站点名称: " + name);
//                System.out.print(", 站点 URL: " + url);
//                System.out.print("\n");
//            }
            // 完成后关闭
            // rs.close();
            //     stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            //           try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            // }
            System.out.println("Goodbye!");
        }
    }
    public static void exec3(Connection conn){
        try {
            Date now = new Date(System.currentTimeMillis());
            conn.setAutoCommit(false);
            Long beginTime = System.currentTimeMillis();
            //构造预处理statement
            PreparedStatement pst = conn.prepareStatement("insert into user(name,age,create_time,update_time) values (?,?,?,?)");
            //1万次循环
            for(int i=1;i<=100000;i++){
                pst.setString(1,"test"+i);
                pst.setInt(2,10);
                pst.setDate(3,now);
                pst.setDate(4,now);
                pst.addBatch();
                //每1000次提交一次
                if(i%10000==0){//可以设置不同的大小；如50，100，500，1000等等
                    pst.executeBatch();
                    conn.commit();
                    pst.clearBatch();
                }
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("批处理执行时间："+(endTime-beginTime)/1000+"秒");
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exec4(Connection conn){
        try {
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
            Date now = new Date(System.currentTimeMillis());
            conn.setAutoCommit(false);
            Long beginTime = System.currentTimeMillis();
            //构造预处理statement
            PreparedStatement pst = conn.prepareStatement("insert into user(name,age,create_time,update_time) values (?,?,?,?)");
            //1万次循环
            for(int i=1;i<=4000000;i++){
                fixedThreadPool.execute(new Runnable() {
                    public void run() {
                        try {
                            pst.setString(1,"test");
                            pst.setInt(2,10);
                            pst.setDate(3,now);
                            pst.setDate(4,now);
                            pst.addBatch();
                            //每1000次提交一次
                            //if(i%25000==0){//可以设置不同的大小；如50，100，500，1000等等
                                pst.executeBatch();
                                conn.commit();
                                pst.clearBatch();
                           // }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("批处理执行时间："+(endTime-beginTime)/1000+"秒");
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void test1(Connection conn) throws Exception
     {
         Long beginTime = System.currentTimeMillis();
                String sql = "{CALL insertuserdata()}"; //调用存储过程
                CallableStatement cstm = conn.prepareCall(sql); //实例化对象cstm
                //cstm.setString(1, "myd"); //存储过程输入参数
                //cstm.setInt(2, 2); // 存储过程输入参数
               // cstm.registerOutParameter(2, Types.INTEGER); // 设置返回值类型 即返回值
                cstm.execute(); // 执行存储过程
           Long endTime = System.currentTimeMillis();
           System.out.println("批处理执行时间："+(endTime-beginTime)/1000+"秒");
                //System.out.println(cstm.getInt(2));
                cstm.close();
            }
}
