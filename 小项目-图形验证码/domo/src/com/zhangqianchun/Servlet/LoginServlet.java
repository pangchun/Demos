package com.zhangqianchun.Servlet;

import com.zhangqianchun.Pojo.User;
import com.zhangqianchun.Pojo.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String randomNum = req.getParameter("randomNum");
        String randomNum_session = ((String) session.getAttribute("randomNum")).replaceAll(" ","");


        User user = UserDB.find(username,password);

        if (user != null && randomNum.equals(randomNum_session)){

            resp.getWriter().write("ok");

        }else {

            resp.getWriter().write("fail");
            return;

        }



    }
}
