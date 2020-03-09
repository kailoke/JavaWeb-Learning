package NameCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 接收UsernameCheck.html的ajax请求，检查用户名是否可使用
 */

@WebServlet(name = "NameCheck.NameCheckServlet", urlPatterns = "/checkUsername")
public class NameCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("NameCheck.NameCheckServlet 收到ajax请求");
        String username = request.getParameter("username");
        String msg;
        // 测试，tom已被占用
        if ("tom".equals(username)) {
            msg = "<font color='red'>用户名已被占用</font>";
        } else {
            msg = "<font color='green'>用户名可以使用</font>";
        }
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.getWriter().write(msg);
    }
}
