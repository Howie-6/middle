package com.example.middle.servlet;

import com.example.middle.DAO.TestDAO;
import com.example.middle.bean.Subject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    static public ArrayList<Integer> main_key = new ArrayList<>();
    /*
    static public ArrayList<Integer> shanchu = new ArrayList<>();       //删掉几行，用来测试
    protected void test(){
        //删掉几行
        shanchu.add(2);
        shanchu.add(44);
        shanchu.add(1);
        main_key=shanchu;
    }
    */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String subject = request.getParameter("subject");
        int number; //题目数量
        TestDAO testDAO = new TestDAO();
        ArrayList<Subject> subjects = new ArrayList<>();

        request.setAttribute("name", name);
        request.setAttribute("subject", subject);
        if (!name.equals("")) {
            if (!subject.equals("")) {
                switch (subject) {
                    case "chinese":
                        try {
                            subjects = (ArrayList<Subject>) testDAO.testChinese();
                            main_key = (ArrayList<Integer>) testDAO.keyChinese();
                            System.out.println("chinese表中有" + subjects.size() + "条数据");
                            number=subjects.size(); //不能删
                            request.setAttribute("number", number);
                            request.setAttribute("list", subjects);
                            request.setAttribute("main_key", main_key);
//                            System.out.println("main_key: " + main_key);
                            request.getRequestDispatcher("test.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println("考试获取信息失败！");
                        }

                        break;
                    case "math":
                        try {
                            subjects = (ArrayList<Subject>) testDAO.testMath();
                            main_key = (ArrayList<Integer>) testDAO.keyMath();
                            System.out.println("math表中有" + subjects.size() + "条数据");
                            number=subjects.size(); //不能删
                            request.setAttribute("number", number);
                            request.setAttribute("list", subjects);
                            request.setAttribute("main_key", main_key);
//                            System.out.println("main_key: " + main_key);
                            request.getRequestDispatcher("test.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println("考试获取信息失败！");
                        }
                        break;
                    case "english":
                        try {
                            subjects = (ArrayList<Subject>) testDAO.testEnglish();
                            main_key = (ArrayList<Integer>) testDAO.keyEnglish();
                            System.out.println("english表中有" + subjects.size() + "条数据");
                            number=subjects.size(); //不能删
                            request.setAttribute("number", number);
                            request.setAttribute("list", subjects);
                            request.setAttribute("main_key", main_key);
//                            System.out.println("main_key: " + main_key);
                            request.getRequestDispatcher("test.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println("考试获取信息失败！");
                        }
                        break;
                }
            } else {
                String subject_null = "科目不能为空！";
                request.setAttribute("subject_null", subject_null);
                request.getRequestDispatcher("studentinformation.jsp").forward(request, response);
            }

        } else {
            String name_null = "姓名不能为空！";
            System.out.println(name_null);
            request.setAttribute("name_null", name_null);
            request.getRequestDispatcher("studentinformation.jsp").forward(request, response); //带数据的页面跳转
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
