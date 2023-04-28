package com.example.middle.servlet;

import com.example.middle.DAO.StudentInfoDAO;
import com.example.middle.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "stuDisplayScore", value = "/stuDisplayScore")
public class StuDisplayScore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//配置输出字符集
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("<center>");
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        ArrayList<Student> students2 = new ArrayList<Student>();
        try {
            students2 = (ArrayList<Student>) studentInfoDAO.studentDisplay2();
            request.setAttribute("list2", students2); //保存了一个变量名为users的数据，数据内容就是从数据中读取的所有用户信息

            //如何把request中保存的数据返回给客户端
            request.getRequestDispatcher("normal_user_display_score.jsp").forward(request, response); //带数据的页面跳转
//            response.sendRedirect("display.jsp");  //也可以进行页面跳转，但是不带数据
            //getRequestDispatcher的作用：进行页面跳转
        } catch (Exception e) {
            System.out.println("Select error?");//还是出错了
        }
        out.print("</center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
