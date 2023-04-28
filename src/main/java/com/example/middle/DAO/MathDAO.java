package com.example.middle.DAO;

import java.sql.*;

public class MathDAO {
    final private String className = "com.mysql.cj.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai&useSSL=false";
    final private String username = "root";
    final private String password = "123456";
    private Connection conn;

    static int score = 0;

    //获取链接的方法
    public Connection getConn() {
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public int Count() {
        //先建立数据库连接,执行查询语句
        int count = 0;

        try {
            Statement sta = getConn().createStatement();
            ResultSet rs = null;
            rs = sta.executeQuery("select count(*) as result from math");
            //创建变量存取个数
            rs.next();
            count = rs.getInt(1) + 1;   //因为后面会有插入一条信息
            System.out.println("Math表有" + count + "条信息");

        } catch (SQLException e) {
            System.out.println("Count() 有问题！");
        }
        return count;
    }

    public int UpdateScore() {
        score = 100 / Count();

        String sqlStr = "update math set score = " + score;
        try {
            PreparedStatement sta = getConn().prepareStatement(sqlStr);
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UpdateScore(int number)  有问题！");
        }
        return score;
    }

    public void Add(int number, String question, int keyx, String xx1, String xx2, String xx3, String xx4) {
        PreparedStatement pst = null;

        score = UpdateScore();
        System.out.println("score值为" + score);
        String sqlStr = "insert into math (type,number,question,score, keyx, xx1, xx2, xx3, xx4) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String type = "单选";
        try {
            pst = conn.prepareStatement(sqlStr);
            pst.setString(1, type);
            pst.setInt(2, number);
            pst.setString(3, question);
            pst.setInt(4, score);
            pst.setInt(5, keyx);
            pst.setString(6, xx1);
            pst.setString(7, xx2);
            pst.setString(8, xx3);
            pst.setString(9, xx4);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("添加Math信息有问题！");
        }
    }

    public void UpdateNumber() {
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = getConn().createStatement();
            statement.executeUpdate("truncate table math_copy1");
            String sqlNew = "INSERT INTO math_copy1(type, question, score, keyx, xx1, xx2, xx3, xx4) SELECT type, question, score, keyx, xx1, xx2, xx3, xx4 FROM math;";
            statement.executeUpdate(sqlNew);
            statement.executeUpdate("truncate table math");
            String sqlNew2 = "INSERT INTO math SELECT * FROM math_copy1;";
            statement.executeUpdate(sqlNew2);
        } catch (SQLException e) {
            System.out.println("UpdateNumber方法有问题！");
        }
    }
}
