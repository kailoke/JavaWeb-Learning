package A1_Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 服务器启动时加载Servlet-Class
 * web.xml <servlet>中配置<load-on-startup>int启动优先级(越小越高)</load-on-startup>
 *  > tomcat/conf/web.xml中有默认Servlet优先级为1，自定义Servlet优先级都应>=2
 */
public class a3_LoadOnStartup implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("call Servlet3 init()...");
    }

    @Override
    public void destroy() {
        System.out.println("call Servlet3 destroy()...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("call Servlet3 service()...");
        servletResponse.getWriter().println("<p><font color='green'>Hello Servlet3 implemented Servlet...<font></p>");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
