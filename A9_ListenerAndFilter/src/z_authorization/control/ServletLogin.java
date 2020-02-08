package z_authorization.control;

import z_authorization.domain.User_table;
import z_authorization.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 使用Filter进行是否成功登录验证
 */

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            // 1.保存用户信息至会话
            HttpSession session = request.getSession();
            session.setAttribute("userExist",userExist);
            // 2.跳转
            response.sendRedirect(request.getContextPath() + "/jsp/success.jsp");
        }
    }
}
