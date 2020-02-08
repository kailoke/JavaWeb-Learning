package a3_MVCLoginTest.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import a3_MVCLoginTest.domain.User_table;
import a3_MVCLoginTest.model.UserModel;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    // 记录成功登陆的人数：方式一
    public static int loginCount = 0;

    // 记录成功登陆的人数：方式二； 或创建另Servlet实现类加载时启动
    @Override
    // 初始化ServletContext Attribute
//    public void init() {
//        this.getServletContext().setAttribute("loginCount",i);
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收数据
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.封装数据
        User_table user = new User_table();
        user.setUser(username);
        user.setPassword(password);
        // 3.处理数据
        User_table existUser = null;
        try {
            existUser = UserModel.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 4.页面跳转
        if (existUser == null) {
            // 登陆失败
            request.setAttribute("msg","用户名或密码错误！");
            // 请求转发，转发Request域对象数据
            request.getRequestDispatcher("/loginTest/login.jsp").forward(request,response);
        }else {
            // 登陆成功
            request.removeAttribute("msg");
            this.getServletContext().setAttribute("nickname",existUser.getNickname());
            //(int)this.getServletContext().getAttribute("loginCount")
            this.getServletContext().setAttribute("count", ++LoginServlet.loginCount);
            response.sendRedirect("/JSP/loginTest/success.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
