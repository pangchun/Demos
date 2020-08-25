package com.zhangqianchun.Servlet;

import com.zhangqianchun.pojo.User;
import com.zhangqianchun.pojo.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8"); // ����Ҫ��Ʊ����ʽ����Ȼ���Ĵ�����̨�����롣

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = UserDB.find(username,password);

        if (user != null){

            if (req.getParameter("autoLogin") != null) {

                /* ����Cookie�����˻������� ע�⣺Ҫ������ת��֮ǰ����Cookie������Cookie�������ͻ���*/

                Cookie cook_name = new Cookie("username",username);
                Cookie cook_pwd = new Cookie("password",password);

                cook_name.setMaxAge(1000);
                cook_pwd.setMaxAge(1000);

                resp.addCookie(cook_name);
                resp.addCookie(cook_pwd);
            }

            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            req.getRequestDispatcher("WEB-INF/view/success.jsp").forward(req,resp);

        }else {

            resp.getWriter().write("��¼ʧ��");
        }
    }
}
