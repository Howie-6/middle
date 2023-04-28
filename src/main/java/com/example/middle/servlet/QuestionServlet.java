package com.example.middle.servlet;

import com.example.middle.DAO.ChineseDAO;
import com.example.middle.DAO.EnglishDAO;
import com.example.middle.DAO.MathDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuestionServlet", value = "/QuestionServlet")
public class QuestionServlet extends HttpServlet {

    static public int number = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type;
        String question;
        int keyx;
        String xx1;
        String xx2;
        String xx3;
        String xx4;
        boolean flag = false;     //做标记，添加题目失败的情况
        type = request.getParameter("type");
        question = request.getParameter("question");
        keyx = Integer.parseInt(request.getParameter("key"));
        xx1 = request.getParameter("choice1");
        xx2 = request.getParameter("choice2");
        xx3 = request.getParameter("choice3");
        xx4 = request.getParameter("choice4");


        if (question.equals("")) {
            String wrong = "问题不能为空！";
            flag = true;
            request.setAttribute("wrong", wrong);
        } else if (xx1.equals("") || xx2.equals("") || xx3.equals("") || xx4.equals("")) {
            flag = true;
            String wrong = "选项不能为空！";
            request.setAttribute("wrong", wrong);
        } else if (keyx == 0 || type.equals("")) {
            flag = true;
            String wrong = "你没有点单选框！";
            request.setAttribute("wrong", wrong);
        } else {
            number++;   //题目数量增加了
            switch (type) {
                case "chinese":
                    ChineseDAO chineseDAO = new ChineseDAO();
                    try {
                        chineseDAO.Add(number, question, keyx, xx1, xx2, xx3, xx4);
                        chineseDAO.UpdateNumber();  //更新number排序
                        System.out.println("chinese表更新成功！");
                    } catch (Exception e) {
                        System.out.println("ChineseDAO有问题！");
                    }
                    break;
                case "math":
                    MathDAO mathDAO = new MathDAO();
                    try {
                        mathDAO.Add(number, question, keyx, xx1, xx2, xx3, xx4);
                        mathDAO.UpdateNumber();
                        System.out.println("math表更新成功！");
                    } catch (Exception e) {
                        System.out.println("MathDAO有问题！");
                    }
                    break;
                case "english":
                    EnglishDAO englishDAO = new EnglishDAO();
                    try {
                        englishDAO.Add(number, question, keyx, xx1, xx2, xx3, xx4);
                        englishDAO.UpdateNumber();
                        System.out.println("math表更新成功！");
                    } catch (Exception e) {
                        System.out.println("MathDAO有问题！");
                    }
                    break;
            }
        }
        if (flag) {
            // 再次进入add_questions.jsp
            request.setAttribute("xx1", xx1);
            request.setAttribute("xx2", xx2);
            request.setAttribute("xx3", xx3);
            request.setAttribute("xx4", xx4);
            request.setAttribute("question", question);
        }
        request.getRequestDispatcher("admin/add_questions.jsp").forward(request, response); //带数据的页面跳转
//        response.sendRedirect("admin/add_questions.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
