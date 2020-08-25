import javax.servlet.*;
import java.io.IOException;

//使用Servlet需要导入 apache-tomcat\lib 下的 servlet-api jar包，
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我被初始化啦！");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("Hello Servlet!");
        System.out.println("我被访问啦！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("我被销毁啦！呜呜呜");
    }
}
