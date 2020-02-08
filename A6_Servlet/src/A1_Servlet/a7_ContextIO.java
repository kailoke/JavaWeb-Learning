package A1_Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** ServletContext读取WEB项目内文件
 * ServletContext!.getResourceAsStream("相对于工程目录")
 */
@WebServlet(name = "a7_ServletIO")
public class a7_ContextIO extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("<h1>ServletIO...</h1>");
//        javaIO(response);
        servletIO(response);
    }
    // 一、Context!.getResourceAsStream("ContextPath/下的路径")
    private void servletIO(HttpServletResponse response) throws IOException {
        ServletContext context = this.getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/jdbc.properties");

        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        response.getWriter().println("url:"+ url + "<br/>");
        String driverClass = properties.getProperty("driverClass");
        response.getWriter().println("driverClass:"+ driverClass + "<br/>");
        String user = properties.getProperty("user");
        response.getWriter().println("user:"+ user + "<br/>");
        String password = properties.getProperty("password");
        response.getWriter().println("password:"+ password + "<br/>");

        is.close();
    }

    // 二、传统方式 ClassLoader.getSystemResourceAsStream()
    private void javaIO(HttpServletResponse response) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("./WEB-INF/jdbc.properties");
        Properties properties = new Properties();
        try {
            assert is != null;
            // HTTP Status 500 – Internal Server Error
            // java.lang.NullPointerException: inStream parameter is null
            // 相对路径，此处相对是tomcat\bin
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        response.getWriter().println("url:"+ url + "<br/>");
        String driverClass = properties.getProperty("driverClass");
        response.getWriter().println("driverClass:"+ driverClass + "<br/>");
        String user = properties.getProperty("user");
        response.getWriter().println("user:"+ user + "<br/>");
        String password = properties.getProperty("password");
        response.getWriter().println("password:"+ password + "<br/>");

        is.close();
    }
}
