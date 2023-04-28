package com.example.middle.DAO;

import com.example.middle.servlet.QuestionServlet;

import java.sql.*;

public class ChineseDAO {
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
            rs = sta.executeQuery("select count(*) as result from chinese");
            //创建变量存取个数
            rs.next();
            count = rs.getInt(1) + 1;   //因为后面会有插入一条信息
            System.out.println("chinese表有" + count + "条信息");

        } catch (SQLException e) {
            System.out.println("Count() 有问题！");
        }
        return count;
    }

    public int UpdateScore() {
        score = 100 / Count();

        String sqlStr = "update chinese set score = " + score;
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
        String sqlStr = "insert into chinese (type,number,question,score, keyx, xx1, xx2, xx3, xx4) " +
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
            System.out.println("添加Chinese信息有问题！");
        }
    }

    //chinese表拷贝到chinese_copy1表，先销毁chinese_copy1表里数据
    public void UpdateNumber() {
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = getConn().createStatement();
            statement.executeUpdate("truncate table chinese_copy1");
            String sqlNew = "INSERT INTO chinese_copy1(type, question, score, keyx, xx1, xx2, xx3, xx4) SELECT type, question, score, keyx, xx1, xx2, xx3, xx4 FROM chinese;";
            statement.executeUpdate(sqlNew);
            statement.executeUpdate("truncate table chinese");
            String sqlNew2 = "INSERT INTO chinese SELECT * FROM chinese_copy1;";
            statement.executeUpdate(sqlNew2);
        } catch (SQLException e) {
            System.out.println("UpdateNumber方法有问题！");
        }
    }
}
