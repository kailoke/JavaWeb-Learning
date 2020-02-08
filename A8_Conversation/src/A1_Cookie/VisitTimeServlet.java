package A1_Cookie;

import A0_CookieUtils.CookieUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * for:记录用户上次访问时间
 * 第一次访问
 *  > true: 1.您好，欢迎来到本网站
 *          2.记录当前系统时间，创建Cookie对象，回写到Browser
 *  > false：1.获得Request.getCookies，解析Cookie[]显示
 *           2.记录当前系统时间，创建Cookie对象，回写到Browser
 *
 *  = 空格 ; 等特殊字符的处理 encoder && decoder
 *  > 发送：URLEncoder.encode()    接收：URLDecoder.decode()
 */

@WebServlet(name = "VisitTimeServlet")
public class VisitTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie lastLoginTime = CookieUtils.findCookie(request.getCookies(), "lastLoginTime");

        // 设置编码格式
//        response.setHeader("Content-Type","text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        if (lastLoginTime == null) {
            // 第一次访问
            response.getWriter().println("<h1>您好，欢迎来到本网站</h1>");
        }else {
            String value = lastLoginTime.getValue();
            response.getWriter().println("<h1>您好，您的最近一次登录时间：" + URLDecoder.decode(value, StandardCharsets.UTF_8) + "</h1>");
        }

        // 记录时间并回写Cookie
        Date date = new Date();
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String encode = URLEncoder.encode(timeStr, StandardCharsets.UTF_8);

        Cookie lastVisit = new Cookie("lastLoginTime", encode);
        // 设置WEB项目有效路径
        lastVisit.setPath("/Conversation");
        // 设置有效期
        lastVisit.setMaxAge(10);

        // 通过response回写Cookie
        response.addCookie(lastVisit);
    }
}
