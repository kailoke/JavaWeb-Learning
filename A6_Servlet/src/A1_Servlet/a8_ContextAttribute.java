package A1_Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** ServletContext作为"域对象"存取数据
 * 一、常用方法
 *  > 1.存入数据(键值对)
 *      void setAttribute(String name, Object val)
 *  > 2.获取数据(键值对)
 *      Object getAttribute(String name)
 *  > 3.移除数据
 *      void removeAttribute(String name)
 * 二、作用域：WEB项目内所有Servlet共享
 *  > 服务器开启后每个WEB项目都有唯一一个ServletContext对象，直到该WEB项目被销毁
 *  > 整个WEB项目内的Servlet都可以使用此WEB项目ServletContext对象
 */

@WebServlet(name = "a8_ContextAttribute")
public class a8_ContextAttribute extends HttpServlet {
    @Override
    // 当此Servlet被初始化，tomcat为之建立了ServletContext实例
    public void init() throws ServletException {
        ServletContext context = this.getServletContext();
        context.setAttribute("name","张三");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) this.getServletContext().getAttribute("name");
        response.getWriter().println("a8_getServletContext.name:" + name);
    }
}
