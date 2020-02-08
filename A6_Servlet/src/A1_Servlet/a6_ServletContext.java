package A1_Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/** ServletContext : 每个WEB项目的Servlet上下文(环境)对象
 * 一、定义：一个WebApp仅有一个ServletContext对象
 *  > 创建：服务器"启动时"为每个WEB项目创建单独实例
 *  > 销毁：当WEB项目从服务器中移除，或服务器关闭时，此ServletContext对象将被销毁
 * 二、获得WEB项目单例实例：Servlet[.getServletConfig()].getServletContext()
 * 三、作用：
 *  > 1. 获取整个WEBApp的信息
 *      > String getMimeType(String file)       获取文件的MIME类型(文件上传、下载时需要)
 *      > String getContextPath()               获取WEB项目请求工程名
 *      > String getInitParameter(String name)  <context-param> 获取WEB项目的(全局)<param-name>对应的<param-value>
 *      > Enumeration<T> getInitParameterNames()<context-param> 获取WEB项目的(全局)所有<param-name>
 *  > 2. context.getResourceAsStream()
 *      > 根目录为项目目录，用于读取"WEB项目(getContextPath)"下的文件
 *  > 3. 作为"域对象"存取数据 Attribute(Object)
 */

public class a6_ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>ServletContext ...</h1>");

        // 获得ServletContext对象
        ServletContext context = this.getServletContext();
        // 1. 获得文件的MIME类型
        String mimeType = context.getMimeType("aa.txt");
        response.getWriter().println("mimeType:" + mimeType + "<br/>");

        // 2. 获取WEB项目的工程名
        String contextPath = context.getContextPath();
        response.getWriter().println("contextPath:" + contextPath + "<br/>");

        // 3. 获得WEB项目的(全局)<context-param>键值对参数
        Enumeration<String> names = context.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = context.getInitParameter(name);
            response.getWriter().println(name + " - " + value + "<br/>");
        }

        response.getWriter().println("<h1>ServletContext area test</h1>");
        response.getWriter().println("a6_ServletContext.name:" + this.getServletContext().getAttribute("name").toString());
    }
}
