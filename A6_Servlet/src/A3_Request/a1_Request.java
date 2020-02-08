package A3_Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/** HttpServletRequest 对象的API
 * 一、获得客户机信息(user-agent)
 *  > String getRemoteAddr() 获得客户机的IP地址
 *  > String getMethod() 获得请求方式
 *  > String getQueryString() 获得提交参数字符串
 *  > String getRequestURI() 获得URL
 *  > StringBuffer getRequestURL() 获得URL
 * 二、获得请求头信息
 *  > 获得键只有一个值的方法
 *      > String getHeader(String name) 获得键的值
 *      > long getDateHeader(String name) 获得键的值
 *  > 获得键有多个值的方法
 *      >   键值枚举：Enumeration getHeaders(String name)
 *      > 所有键枚举：Enumeration getHeaderNames()
 * 三、获得请求体(参数)
 *  > 键的值：  String getParameter(String name)
 *  > 键值数组：String[] getParameterValues(String name)
 *  > 键值Map:  Map getParameterMap()
 * 四、Request作为域对象存取数据，!使用请求转发 ServletRequest.RequestDispatcher(String path).forward(Request,Response)
 *  > void setAttribute(String name, Object val)
 *  > Object getAttribute(String name)
 *  > void removeAttribute(String name)
 */
@WebServlet(name = "a1_Request")
public class a1_Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 缓冲区编码
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        // 一、获得客户机信息
        // http://192.168.0.103/
        response.getWriter().println("<h2>一、获取客户机信息</h2>");
        String remoteAddr = request.getRemoteAddr();
        int remotePort = request.getRemotePort();
        String method = request.getMethod();

        response.getWriter().println("method: " + method + "<br/>"
                + "remoteAddr: " + remoteAddr + "<br/>"
                + "remotePort: " + remotePort + "<br/>");

        response.getWriter().println("getRequestURI: " + request.getRequestURI() + "<br/>");
        response.getWriter().println("getRequestURL: " + request.getRequestURL() + "<br/>");

        // 二、获取请求头参数：Header
        response.getWriter().println("<h2>二、获取请求头参数</h2>");
        response.getWriter().println("User-Agent: " + request.getHeader("User-Agent") + "<br/>");

        // 三、获取请求参数
        // get/post 发送的数据都封装在 Request对象中
        response.getWriter().println("<h2>三、获取请求参数</h2>");
        response.getWriter().println("<h3>3.1 get/post的方式请求参数都可以被获取，只是发送方式不同：</h3>");
        response.getWriter().println("getQueryString: " + request.getQueryString() + "<br/>");
        response.getWriter().println("username_getParameter: " + request.getParameter("username") + "<br/>");
        response.getWriter().println("password_getParameter: " + request.getParameter("password") + "<br/>");
        response.getWriter().println("hobby_getParameterValues: " + Arrays.toString(request.getParameterValues("hobby")) + "<br/>");
        response.getWriter().println("selfIntroduce_getParameter: " + request.getParameter("selfIntroduce") + "<br/>");

        // 获取Request对象中的所有参数信息存入Map集合
        response.getWriter().println("<h3>3.2 请求体参数存入 Map</h3>");
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            response.getWriter().println(key + ": " + Arrays.toString(values) + "<br/>");
        }
    }
}
