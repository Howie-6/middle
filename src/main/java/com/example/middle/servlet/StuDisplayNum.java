package com.example.middle.servlet;

import com.example.middle.DAO.StudentInfoDAO;
import com.example.middle.bean.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StuDisplayNum", value = "/StuDisplayNum")
public class StuDisplayNum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("<center>");
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        ArrayList<Student> students3 = new ArrayList<Student>();
        try {
            students3 = (ArrayList<Student>) studentInfoDAO.studentDisplay3();
            System.out.println("students3：一共" + students3.size() + "条数据");
            request.setAttribute("list3", students3); //保存了一个变量名为users的数据，数据内容就是从数据中读取的所有用户信息

            //如何把request中保存的数据返回给客户端
            request.getRequestDispatcher("normal_user_display_number.jsp").forward(request, response); //带数据的页面跳转

        } catch (Exception e) {
            System.out.println("Select error?!!");//还是出错了
        }
        out.print("</center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
