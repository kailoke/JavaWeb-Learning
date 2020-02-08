package z_authorization.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 接收中文数据的Servlet from /jsp/sub.jsp
 */
@WebServlet(name = "charSet")
public class Charset extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post参数==请求体，服务器接收数据至Request对象缓冲区(ISO-8859-1)
//        request.setCharacterEncoding("UTF-8");    // 注释此行使用Filter
        System.out.println("post 接收 name: " + request.getParameter("name"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get参数==URL?&&(已经进行URL编码)
        // 服务器接收数据值Request对象缓冲区(IOS-8859-1)
        // <!-- 1.URLEncoder取出缓冲区数据(charSet="ISO-8859-1") -->

        // URLDecoder进行URL解码(chatSet="UTF-8")
//        System.out.println(URLDecoder.decode(request.getQueryString(), StandardCharsets.UTF_8));    // 注释此行使用Filter
        System.out.println("get 接收 name: " + request.getParameter("name"));
    }
}
