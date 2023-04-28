package com.example.middle.servlet;

import com.example.middle.DAO.TestDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ScoreResultServlet", value = "/ScoreResultServlet")
public class ScoreResultServlet extends HttpServlet {
    static int count=3; //本来有三场考试
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String subject = request.getParameter("subject");
        String sum_string = request.getParameter("sum");

        int sum = Integer.parseInt(sum_string);
//        System.out.println("你回答了"+sum+"个");
        int score = 100 / sum;
        //获取TestServlet的main_key所有值
        int n = 0;
        String answer_string;
        int answer;
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < sum; i++, n++) {
            answer_string = request.getParameter(String.valueOf(n));
//            System.out.println("answer_string : " + answer_string);
            answer = Integer.parseInt(answer_string);   //!!
            answers.add(answer);
        }
        System.out.println("answers=  " + answers);
        //获取TestServlet里main_key所有值
        System.out.println("main_key=  " + TestServlet.main_key);

        //answers和main_key比较
        TestDAO testDAO = new TestDAO();
//        System.out.println("检查："+testDAO.twoArraysCompareTo(testServlet.main_key, answers, sum, score));    //为什么返回结果为0？？？

        int result = testDAO.twoArraysCompareTo(TestServlet.main_key, answers, sum, score);
        request.setAttribute("result", result);
//        response.sendRedirect("score_result.jsp");
        count--;    //考试场数递减
        request.setAttribute("count", count);
        request.setAttribute("name", name);
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("score_result.jsp").forward(request, response); //带数据的页面跳转
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
