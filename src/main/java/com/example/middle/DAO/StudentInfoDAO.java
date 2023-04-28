package com.example.middle.DAO;

import com.example.middle.bean.Student;

import java.sql.*;
import java.util.*;

public class StudentInfoDAO {
    final private String className = "com.mysql.cj.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai&useSSL=false";
    final private String username = "root";
    final private String password = "123456";
    private Connection conn;

    ArrayList<Student> list = new ArrayList<>();

//    static public Map<Integer,Integer> map1=new HashMap<>();

    static public ArrayList<Student> list2 = new ArrayList<>();


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

    public List studentDisplay() throws Exception {

        //自动抽取变量快捷键：command + option + V (如：conn.createStatement() )
        Statement statement = getConn().createStatement();
        String sqlStr = "select * from score";
        ResultSet resultSet = statement.executeQuery(sqlStr);

        while (resultSet.next()) {
            Student student = new Student();
            student.setNumber(resultSet.getInt("number"));
            student.setName(resultSet.getString("name"));
            student.setChinese(resultSet.getInt("chinese"));
            student.setMath(resultSet.getInt("math"));
            student.setEnglish(resultSet.getInt("english"));
//            map1.put(i++,resultSet.getInt("chinese")+resultSet.getInt("math")+resultSet.getInt("english"));
            list.add(student);
        }

        // 关闭链接
        resultSet.close();
        statement.close();
        conn.close();
        return list;
    }

    //按着成绩总分排序
    public List studentDisplay2() throws Exception {
        //带数据
        studentDisplay();

        list2 = list;
        Collections.sort(list2, Collections.reverseOrder());
        conn.close();
        return list2;
    }

    //按着number排序
    public List studentDisplay3() throws Exception {
        ArrayList<Student> list3 = new ArrayList<>();

        Statement statement = getConn().createStatement();

        ResultSet resultSet;
        statement.executeUpdate("truncate table ranking");

        //降序：desc   升序：asc

        String sqlStr0 = "insert into ranking(number,name,chinese,math,english,ranks) " +
                "select number, name,chinese,math,english,rank() over (order by (chinese+math+english) desc) " +
                "as ranking from score;";

        statement.executeUpdate(sqlStr0);

        String sqlStr = "select * from ranking order by number asc;";
        resultSet = statement.executeQuery(sqlStr);

        while (resultSet.next()) {
            Student student3 = new Student();
            student3.setNumber(resultSet.getInt("number"));
            student3.setName(resultSet.getString("name"));
            student3.setChinese(resultSet.getInt("chinese"));
            student3.setMath(resultSet.getInt("math"));
            student3.setEnglish(resultSet.getInt("english"));
            student3.setRanking(resultSet.getInt("ranks"));
            list3.add(student3);
        }
//        statement.executeUpdate("truncate table ranking");

        resultSet.close();
        statement.close();
        conn.close();
        return list3;
    }


    public void studentAdd(String name, int chinese, int math, int english) throws Exception {
        //sql语句
        String sqlStr = "insert into score (name,chinese,math,english) " +
                "values (?, ?, ?, ?)";    //带参数带sql语句
        PreparedStatement pst = getConn().prepareStatement(sqlStr);
        pst.setString(1, name);
        pst.setInt(2, chinese);
        pst.setInt(3, math);
        pst.setInt(4, english);
        pst.executeUpdate();

        //关闭
        pst.close();
        conn.close();
    }

    public void studentDelete(int number) throws Exception {
        String sqlStr = "delete from score where number = ?";
        PreparedStatement sta = getConn().prepareStatement(sqlStr);
        sta.setInt(1, number);
        sta.executeUpdate();
        sta.close();
        conn.close();
    }

    public Student getStudentById(int number) throws Exception {
        String sqlStr = "select * from score where number = ?";
        PreparedStatement sta = getConn().prepareStatement(sqlStr);
        sta.setInt(1, number);
        ResultSet rs = sta.executeQuery();
        Student student = new Student();

        if (rs.next()) {
            student.setNumber(rs.getInt("number"));
            student.setName(rs.getString("name"));
            student.setChinese(rs.getInt("chinese"));
            student.setMath(rs.getInt("math"));
            student.setEnglish(rs.getInt("english"));
            return student;
        }
        rs.close();
        sta.close();
        conn.close();
        return null;
    }

    public void studentUpdate(int number, String name, int chinese, int math, int english) throws Exception {
        String sqlStr = "update score set number = ?, name = ?,chinese = ?,math=?, english=? where number=?";

        PreparedStatement sta = getConn().prepareStatement(sqlStr);
        sta.setInt(1, number);
        sta.setString(2, name);
        sta.setInt(3, chinese);
        sta.setInt(4, math);
        sta.setInt(5, english);
        sta.setInt(6, number);
        sta.executeUpdate();
        sta.close();
        conn.close();
    }
}
