package com.zhangqianchun.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.清空cookie中存储的值
        Cookie username = new Cookie("username",null);
        Cookie password = new Cookie("password",null);

        username.setMaxAge(0);
        password.setMaxAge(0);

        username.setPath(req.getContextPath());
        password.setPath(req.getContextPath());

        resp.addCookie(username);
        resp.addCookie(password);

        HttpSession session = req.getSession();

        //2.清空session中储存的账号密码
        session.setAttribute("user", null);

        resp.sendRedirect("index.jsp");
    }
}
