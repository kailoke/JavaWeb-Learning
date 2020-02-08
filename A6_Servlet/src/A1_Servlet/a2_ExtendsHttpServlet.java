package A1_Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** HttpServlet类
 * 一、关系实现
 *  > Servlet接口
 *      |---- GenericServlet 通用Servlet，与协议无关
 *              |———— HttpServlet Http专用Servlet
 *  > service()方法内根据request method分别调用不同的do(Method)()方法，则仅需要重写请求方式的doXxx()方法
 */

@WebServlet(name = "com.F.servlet.demo1.Servlet")
public class a2_ExtendsHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Hello Servlet extended HttpServlet...</h1>");
    }
}
