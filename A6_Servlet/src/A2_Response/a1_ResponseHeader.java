package A2_Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** HttpServletResponse 对象的API
 * 一、响应行 Status Code
 *  > 设置状态码：setStatus(int val)
 *  > 协议版本，状态码描述
 * 二、响应头
 *  > 2.1键仅有一个值的方法：set设置
 *      > setHeader(String name,String value)
 *      > setDateHeader(String name,long date)
 *      > setIntHeader(String name,int value)
 *  > 2.2键有多个值的方法：add追加
 *      > addHeader(String name,String value)
 *      > addDateHeader(String name,long date)
 *      > addIntHeader(String name,int value)
 * 三、响应体，属于ServletResponse，与协议无关
 *  > 字符流   PrintWriter getWriter()
 *  > 字节流   ServletOutputStream getOutputStream()
 *
 * 四、其他方法
 *  > 1.浏览器&&缓冲区解析字符集：void setContentType(String type)
 *  > 2.设置cookie：void addCookie(Cookie cookie)
 *  > 3.重定向：void sendRedirect(String location)
 *  > 4.设置字符流的缓冲区字符集：void setCharacterEncoding(String charset)
 */

@WebServlet(name = "Response")
public class a1_ResponseHeader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置(set)状态码  / 获得(get)
        response.setStatus(302);
//        response.getWriter().println("response.Status Code: " + response.getStatus() + "<br />");
//        response.setHeader("Location","./http_demo.html");

        //  重定向 sendRedirect
//        response.sendRedirect("./http_demo.html");

        // 2.设置定时刷新
        response.getWriter().println("<p>5secs later will Redirecting to http_demo.html</p>");
        response.setHeader("Refresh","5,url=./http_demo.html");
    }
}
