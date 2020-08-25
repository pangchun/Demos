import Pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MyServlet_2 extends HttpServlet {
    private Map<String,Object> result = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.submit(req,resp);

    }

    public void submit(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String data = null;

        System.out.println(name+password);

        User user = new User("小妲己","123");

        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
            //手动拼接json串，只适用于字符串文本
            data = "{\"success\":true}";// \"  代表一个双引号字符
        }else {
            data = "{\"success\":false}";
        }

        resp.getWriter().write(data);//将数据打印到前台

    }
}
