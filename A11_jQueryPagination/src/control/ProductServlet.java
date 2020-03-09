package control;

import com.alibaba.fastjson.JSONObject;
import domain.PageBean;
import model.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageBean productPageBean = null;
        try {
            productPageBean = ProductService.getPageBean(page, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(productPageBean.toString());
        if (productPageBean != null) {
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JSONObject.toJSONString(productPageBean));
        } else {
            request.setAttribute("msg", "没有数据");
        }
    }
}
