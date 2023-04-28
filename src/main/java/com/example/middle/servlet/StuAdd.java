package com.example.middle.servlet;

import com.example.middle.DAO.StudentInfoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuAdd", value = "/StuAdd")
public class StuAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name;
        int chinese;
        int math;
        int english;
        name = request.getParameter("name");
        chinese = Integer.parseInt(request.getParameter("chinese"));
        math = Integer.parseInt(request.getParameter("math"));
        english = Integer.parseInt(request.getParameter("english"));
        StudentInfoDAO studentInfoDAO=new StudentInfoDAO();
        try {
            studentInfoDAO.studentAdd(name, chinese, math, english);
            System.out.println(name);
        } catch (Exception e) {
            System.out.println("Student Add Error! 原因可能是state长度限制或者数据类型错误！");
        }
        response.sendRedirect("stuDisplay");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
