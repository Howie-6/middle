package com.example.middle.servlet;

import com.example.middle.DAO.StudentInfoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "stuDelete", value = "/stuDelete")
public class StuDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("number"));
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        try {
            studentInfoDAO.studentDelete(id);
        } catch (Exception e) {
            System.out.println("Student delete error!!");
        }
        response.sendRedirect("stuDisplay");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
