package com.example.middle.servlet;

import com.example.middle.DAO.StudentInfoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuUpdate", value = "/StuUpdate")
public class StuUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 为了防止乱吗
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("number"));
        String name = request.getParameter("name");
        int chinese = Integer.parseInt(request.getParameter("chinese"));
        int math = Integer.parseInt(request.getParameter("math"));
        int english = Integer.parseInt(request.getParameter("english"));
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        try {
            studentInfoDAO.studentUpdate(id, name, chinese, math, english);
        } catch (Exception e) {
            System.out.println("Student update error!!");
        }
        response.sendRedirect("stuDisplay");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
