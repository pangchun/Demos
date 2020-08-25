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
             1.������֤��
             2.����֤���ϵ��ı�����session��
             3.����֤��ͼƬ���͸��ͻ���
             */

        Image image = new Image();

        BufferedImage bufferedImage = image.getImage(); //��ȡ��֤��

        req.getSession().setAttribute("randomNum",image.getText()); //����֤����ı�����session��

        //����������������ͼƬ
        resp.setHeader("Expires","-1");
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //֪ͨ�������ͼƬ�ķ�ʽ��
        resp.setHeader("Content-type","image/jpeg");

        image.output(bufferedImage,resp.getOutputStream()); //����֤��ͼƬ��Ӧ���ͻ���
    }
}
