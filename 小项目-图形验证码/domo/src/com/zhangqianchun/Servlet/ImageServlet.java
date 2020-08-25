package com.zhangqianchun.Servlet;

import com.zhangqianchun.Pojo.Image;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
             1.生成验证码
             2.把验证码上的文本存在session中
             3.把验证码图片发送给客户端
             */

        Image image = new Image();

        BufferedImage bufferedImage = image.getImage(); //获取验证码

        req.getSession().setAttribute("randomNum",image.getText()); //将验证码的文本存在session中

        //控制浏览器不缓存该图片
        resp.setHeader("Expires","-1");
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //通知浏览器以图片的方式打开
        resp.setHeader("Content-type","image/jpeg");

        image.output(bufferedImage,resp.getOutputStream()); //将验证码图片响应给客户端
    }
}
