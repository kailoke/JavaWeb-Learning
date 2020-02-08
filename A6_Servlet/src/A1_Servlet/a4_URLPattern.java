package A1_Servlet;

import javax.servlet.*;
import java.io.IOException;

/** <url-pattern> in <servlet-mapping>访问路径方式
 * 一、完全路径：以 / 开始
 *  > 优先级1
 *  > 指定路径才能访问映射的Servlet
 * 二、目录匹配：以 / 开始， * 结束
 *  > 优先级2
 *  > 该目录下的任意路径都将访问映射的Servlet
 * 三、扩展名匹配：以 * 开始
 *  > 优先级3
 *  > 指定扩展名的任意路径都将访问映射的Servlet
 *
 *  例子：
 *<!--完全路径匹配-->
 *  <url-pattern>/servlet4</url-pattern>
 *<!--目录匹配-->
 *  <url-pattern>/aaa/*</url-pattern>
 *<!--扩展名匹配-->
 *  <url-pattern>*.abc</url-pattern>
 */
public class a4_URLPattern implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("call Servlet4 init()...");
    }

    @Override
    public void destroy() {
        System.out.println("call Servlet4 destroy()...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("call Servlet4 service()...");
        servletResponse.getWriter().println("<p><font color='green'>Hello Servlet4 implemented Servlet...<font></p>");
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
