package A1_Servlet;


import javax.servlet.*;
import java.io.IOException;

/** Servlet继承方式
 * > 继承 javax.servlet.Servlet
 */

public class a1_ImplementsServlet implements Servlet {
    /**
     * Servlet第一次被访问时，会实例化对象，此时执行init()
     * 在一个<Servlet>中,Servlet对象是单例的，init()只会被执行一次
     * 默认为访问时加载对象，可能导致第一次访问时耗时较长
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("call Servlet1 init()...");
    }

    /**
     * Servlet从服务器中移除或者服务器关闭的时候销毁Servlet对象，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("call Servlet1 destroy()...");
    }

    /**
     * 处理请求，并对请求作出响应
     * @param servletRequest 请求实例
     * @param servletResponse 响应实例
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 向页面输出一个HelloServlet字符串
        servletResponse.getWriter().println("<p><font color='red'>Hello Servlet implemented Servlet1...<font></p>");
        System.out.println("call Servlet1 service()...");
    }

    // 获取ServletConfig
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    // 获取ServletInfo
    @Override
    public String getServletInfo() {
        return null;
    }
}
