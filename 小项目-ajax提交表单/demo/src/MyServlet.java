import javax.servlet.*;
import java.io.IOException;

//ʹ��Servlet��Ҫ���� apache-tomcat\lib �µ� servlet-api jar����
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("�ұ���ʼ������");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("Hello Servlet!");
        System.out.println("�ұ���������");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("�ұ���������������");
    }
}
