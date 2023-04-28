package com.example.middle.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//这是第一次进入 add_questions.jsp，就是说之后不会再次执行这个。因为长文本框刷新的时候会丢失信息的

@WebServlet(name = "AddQuestionFirst", value = "/AddQuestionFirst")
public class AddQuestionFirst extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String xx1="";
        String xx2="";
        String xx3="";
        String xx4="";
        String question="";
        request.setAttribute("xx1", xx1);
        request.setAttribute("xx2", xx2);
        request.setAttribute("xx3", xx3);
        request.setAttribute("xx4", xx4);
        request.setAttribute("question", question);
        request.getRequestDispatcher("admin/add_questions.jsp").forward(request, response); //带数据的页面跳转
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
