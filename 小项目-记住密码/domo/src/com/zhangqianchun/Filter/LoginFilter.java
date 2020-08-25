package com.zhangqianchun.Filter;

import com.zhangqianchun.pojo.User;
import com.zhangqianchun.pojo.UserDB;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        String username = null;
        String password = null;

        Cookie[] cookies = req.getCookies();

        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) username = cookie.getValue();
                if (cookie.getName().equals("password")) password = cookie.getValue();
            }
        }

        User user = UserDB.find(username,password);

        if (user != null) {

            req.setAttribute("username",username);
            req.setAttribute("password",password);

            session.setAttribute("user",user);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
