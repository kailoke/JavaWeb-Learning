package a2_Goto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 页面跳转的测试Servlet，目标页面是 /web/goto.jsp
 * 一、请求转发 Request.RequestDispatcher
 *  > 1.原理：一次请求、一次响应
 *      > 服务器将请求转发至目标，目标处理后返回给客户端(Request)
 *      > 地址栏不会发生变化，路径不能要项目名(服务器路径)，只能转发至项目内部
 * 二、重定向   Response.SendRedirect
 *  > 1.原理：两次请求、两次响应
 *      > 服务器收到请求后，将目标信息告知客户端，客户端重定向至目标获得响应
 *      > 地址栏重定向至目标，路径需要项目名(客户端路径)，可定向至任何网站
 */
@WebServlet(name = "loginServlet.ServletLoginTest")
public class GotoTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","Linux");

        dispatcher(request,response);   // success.jsp getAttribute:张三
//        redirect(response);           // success.jsp getAttribute:null
    }
    // 一、请求转发：Request!.RequestDispatcher.forward(String path)
    private void dispatcher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/goto.jsp");
        dispatcher.forward(request,response);
    }
    // 二、重定向，需要带工程名的绝对路径
    private void redirect(HttpServletResponse response) {
        try {
            response.sendRedirect("/JSP/goto.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
