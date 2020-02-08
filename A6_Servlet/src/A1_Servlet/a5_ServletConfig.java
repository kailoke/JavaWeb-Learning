package A1_Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/** ServletConfig
 * 一、作用：获得Servlet配置(web.xml中的 <...> in <Servlet>)
 * 二、获得Servlet单例对象：通过Servlet!.getServletConfig() 获得ServletConfig对象
 *      Servlet对象由Tomcat通过web.xml配置创建，并传参至Servlet.init(ServletConfig conf)进行初始化
 * 三、web.xml配置参数 <init-param> param-name & param-value </init-param>
 * 四、常用方法：(均为获得web.xml中的Servlet <init-param> 配置信息)
 *  > String getInitParameter（String name)     param-name 绑定的 param-value
 *  > Enumeration getInitParameterNames()       init-param 绑定的所有 param-name
 *  > String getServletName()                   <Servlet-name>
 *  > ServletContext getServletContext()        获得ServletContext对象，GenericServlet中提供getServletContext调用此方法
 */

@WebServlet(name = "com.F.servlet.demo1.a5_ServletConfig")
public class a5_ServletConfig extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>ServletConfig ...</h1>");

        // 1. 获得ServletConfig对象
        ServletConfig config = this.getServletConfig();
        // 2. 获得所有init-param名称，及其值
        Enumeration<String> names = this.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            response.getWriter().println(name + " - " + value + "<br/>");
        }
        // 3. 获得<servlet-name>
        String servletName = config.getServletName();
        response.getWriter().println("ServletName:" + servletName + "<br/>");

        // 4. 测试获取context-param
        ServletContext context = this.getServletContext();
        Enumeration<String> contextNames = context.getInitParameterNames();
        while (contextNames.hasMoreElements()){
            String name = contextNames.nextElement();
            String value = context.getInitParameter(name);
            response.getWriter().println(name + " - " + value + "<br/>");
        }
    }
}
