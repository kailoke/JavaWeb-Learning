package A3_LoginExercise.controller;

import A3_LoginExercise.domain.User_table;
import A3_LoginExercise.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 登录错误，则保存错误信息，回到登陆页面
 * 登陆成功，则保存信息至会话中，跳转到成功页面
 * 增加验证码校验
 */

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 优先进行验证码校验，验证失败则不进行登陆逻辑，不进行与数据库交互
        String verificationCode = request.getParameter("verificationCode");
        if(!verificationCode.equals(request.getSession().getAttribute("verificationCode"))) {
            // 校验失败则移除验证码，保证一个验证码只能用于一次请求
            request.getSession().removeAttribute("verificationCode");
            request.setAttribute("msg", "验证码错误，请重新输入！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User_table user = new User_table();
        user.setUser(username);
        user.setPassword(password);
        User_table userExist = null;
        try {
            userExist = UserModel.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userExist == null) {
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            // 成功登陆
            // 1.Cookie存储用户名至客户端
            if ("true".equals(request.getParameter("rememberMe"))) {
                System.out.println("save username to cookie");
                Cookie cookie = new Cookie("username", userExist.getUser());
                cookie.setPath("/Conversation");
                cookie.setMaxAge(30);
                response.addCookie(cookie);

                Cookie remCookie = new Cookie("rememberMe", "checked");
                remCookie.setPath(cookie.getPath());
                remCookie.setMaxAge(cookie.getMaxAge());
                response.addCookie(remCookie);
            }
            // 2.保存用户信息至会话
            HttpSession session = request.getSession();
            session.setAttribute("userExist",userExist);
            // 3.跳转
            response.sendRedirect("/Conversation/success.jsp");
        }
    }
}
