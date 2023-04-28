package com.example.middle.servlet;

import com.example.middle.DAO.StudentInfoDAO;
import com.example.middle.bean.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuModify", value = "/StuModify")
public class StuModify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("number"));
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        Student students = new Student();
        try {
            students = studentInfoDAO.getStudentById(number);
        } catch (Exception e) {
            System.out.println("GetStudent by ID error!");
        }
        request.setAttribute("student", students);     // StudentInfoDAO.java getStudentById(int number) 里 "return student;"
        request.getRequestDispatcher("admin/studentModify.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
