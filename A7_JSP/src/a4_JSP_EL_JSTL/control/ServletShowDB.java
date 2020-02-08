package a4_JSP_EL_JSTL.control;

import a3_MVCLoginTest.domain.User_table;
import a4_JSP_EL_JSTL.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletShowDB")
public class ServletShowDB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得DB data
        List<User_table> list = null;
        try {
             list = UserModel.getInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 请求转发数据
        request.setAttribute("list",list);
        request.getRequestDispatcher("/a6_JSP_EL_JSTL/DBShow.jsp").forward(request,response);
    }
}
