package com.example.middle.DAO;

import com.example.middle.bean.KeySubject;
import com.example.middle.bean.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    final private String className = "com.mysql.cj.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai&useSSL=false";
    final private String username = "root";
    final private String password = "123456";
    private Connection conn;


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

    //chinese key
    public List keyChinese() throws Exception {
        Statement statement = getConn().createStatement();
        String sqlStr = "select keyx from chinese";
        ResultSet resultSet = statement.executeQuery(sqlStr);
//        ArrayList<Integer> main_key = new ArrayList<>();
        ArrayList<KeySubject> keySubjects = new ArrayList<>();
        ArrayList<Integer> key=new ArrayList<>();
        while (resultSet.next()) {
            KeySubject subject = new KeySubject();
            subject.setKeyx(resultSet.getInt("keyx"));

            key.add(subject.getKeyx()); //result返回结果为0的根本原因
        }
        resultSet.close();
        statement.close();
        conn.close();
        return key;
    }

    //math key
    public List keyMath() throws Exception {
        Statement statement = getConn().createStatement();
        String sqlStr = "select keyx from math";
        ResultSet resultSet = statement.executeQuery(sqlStr);
//        ArrayList<Integer> main_key = new ArrayList<>();
        ArrayList<KeySubject> keySubjects = new ArrayList<>();
        ArrayList<Integer> key=new ArrayList<>();
        while (resultSet.next()) {
            KeySubject subject = new KeySubject();
            subject.setKeyx(resultSet.getInt("keyx"));

            key.add(subject.getKeyx()); //result返回结果为0的根本原因
        }
        resultSet.close();
        statement.close();
        conn.close();
        return key;
    }

    //english key
    public List keyEnglish() throws Exception {
        Statement statement = getConn().createStatement();
        String sqlStr = "select keyx from english";
        ResultSet resultSet = statement.executeQuery(sqlStr);
//        ArrayList<Integer> main_key = new ArrayList<>();
        ArrayList<KeySubject> keySubjects = new ArrayList<>();
        ArrayList<Integer> key=new ArrayList<>();
        while (resultSet.next()) {
            KeySubject subject = new KeySubject();
            subject.setKeyx(resultSet.getInt("keyx"));

            key.add(subject.getKeyx()); //result返回结果为0的根本原因
        }
        resultSet.close();
        statement.close();
        conn.close();
        return key;
    }

    //answers和main_key比较，a是正确的答案，b是错误的答案，sum是题目的数量；返回的是分数
    public int twoArraysCompareTo(ArrayList<Integer> a, ArrayList<Integer> b, int sum, int score) {
        int n = 0;
        for (int i = 0; i < sum; i++) {
            if (a.get(i).equals(b.get(i))) {
                n++;
            }
        }
        if (n == sum) {
            return 100; //若不写，有三道题目，全做对，结果是99分
        } else {
            return score * n;
        }
    }


    //Chinese
    public List testChinese() throws Exception {
        Statement statement = getConn().createStatement();
        String sqlStr = "select * from chinese";
        ResultSet resultSet = statement.executeQuery(sqlStr);
        ArrayList<Subject> list1 = new ArrayList<>();
        while (resultSet.next()) {
            Subject subject = new Subject();
            subject.setType(resultSet.getString("type"));
            subject.setNumber(resultSet.getInt("number"));
            subject.setQuestion(resultSet.getString("question"));
            subject.setScore(resultSet.getInt("score"));
            subject.setKeyx(resultSet.getInt("keyx"));
            subject.setXx1(resultSet.getString("xx1"));
            subject.setXx2(resultSet.getString("xx2"));
            subject.setXx3(resultSet.getString("xx3"));
            subject.setXx4(resultSet.getString("xx4"));
            list1.add(subject);
        }
        resultSet.close();
        statement.close();
        conn.close();
        return list1;
    }

    //math
    public List testMath() throws Exception {
        Statement statement = getConn().createStatement();
        String sqlStr = "select * from math";
        ResultSet resultSet = statement.executeQuery(sqlStr);
        ArrayList<Subject> list2 = new ArrayList<>();
        while (resultSet.next()) {
            Subject subject = new Subject();
            subject.setType(resultSet.getString("type"));
            subject.setNumber(resultSet.getInt("number"));
            subject.setQuestion(resultSet.getString("question"));
            subject.setScore(resultSet.getInt("score"));
            subject.setKeyx(resultSet.getInt("keyx"));
            subject.setXx1(resultSet.getString("xx1"));
            subject.setXx2(resultSet.getString("xx2"));
            subject.setXx3(resultSet.getString("xx3"));
            subject.setXx4(resultSet.getString("xx4"));
            list2.add(subject);
        }
        resultSet.close();
        statement.close();
        conn.close();
        return list2;
    }

    //english
    public List testEnglish() throws Exception {
        Statement statement = getConn().createStatement();
        String sqlStr = "select * from english";
        ResultSet resultSet = statement.executeQuery(sqlStr);
        ArrayList<Subject> list3 = new ArrayList<>();
        while (resultSet.next()) {
            Subject subject = new Subject();
            subject.setType(resultSet.getString("type"));
            subject.setNumber(resultSet.getInt("number"));
            subject.setQuestion(resultSet.getString("question"));
            subject.setScore(resultSet.getInt("score"));
            subject.setKeyx(resultSet.getInt("keyx"));
            subject.setXx1(resultSet.getString("xx1"));
            subject.setXx2(resultSet.getString("xx2"));
            subject.setXx3(resultSet.getString("xx3"));
            subject.setXx4(resultSet.getString("xx4"));
            list3.add(subject);
        }
        resultSet.close();
        statement.close();
        conn.close();
        return list3;
    }
}
