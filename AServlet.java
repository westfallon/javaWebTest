package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @program: javaWebTest
 * @description: Test ServletConfig a
 * @author: westfallon
 * @create: 2020-06-21 15:28
 **/

public class AServlet implements Servlet {
    private ServletConfig servletConfig = null;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("AServlet's ServletConfig = " + servletConfig.toString());
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out = servletResponse.getWriter();
        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");

        Enumeration<String> names = config.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            out.print(name + " = " + value);
            out.print("<br>");
        }

//        out.print(driver);
//        out.print(url);
//        out.print(username);
//        out.print(password);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
