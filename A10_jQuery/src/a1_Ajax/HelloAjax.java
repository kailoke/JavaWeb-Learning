package a1_Ajax;

import java.io.IOException;

/**
 * 接收AjaxHttp请求，测试Ajax底层流程
 */

@javax.servlet.annotation.WebServlet(name = "HelloAjax")
public class HelloAjax extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello Ajax:received Ajax XMLHttpRequest");
        // 通过IO流向Browser相应数据
        response.getWriter().println("Hello Ajax");
    }
}
