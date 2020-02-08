package A2_Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/** Response 中文问题
 * *客户端编码：setHeader("Content-Type")
 * *服务器编码：setCharacterEncoding(charSet)
 *
 * 核心：程序端设置字符串的编码方式 && 返回浏览器端应解析使用的字符集
 * 一、ServletOutputStream 字节流输出中文，不一定产生乱码，和默认字符集有关
 *  > string.getBytes(String Charset)
 *  > response.setHeader("Content-Type","text/html;charset=UTF-8")
 * 二、PrintStream 字符流输出中文
 *  > 一定会产生乱码，因为Response字符流默认缓冲区编码是ISO-8859-1，不支持中文
 *  > response.setContentType("text/html;charset=UTF-8")
 *      ↑↑↑ 同时修改缓冲区及客户端解码方式
 */

@WebServlet(name = "a2_ResponseBody")
public class a2_ResponseBody extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byteWrite(response);
        stringWrite(response);
    }
    // 1.使用字节流输出中文
    private void byteWrite(HttpServletResponse response) throws IOException {
        ServletOutputStream os = response.getOutputStream();
        os.write("<p>张三报道!</p>".getBytes(StandardCharsets.UTF_8));
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        os.close();
    }
    // 2.使用字符流输出中文
    private void stringWrite(HttpServletResponse response) throws IOException {
        // 2.1原始流程，默认Content-Type的charset=UTF-8
//        response.setHeader("Content-Type","text/html;ccc");
//        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        // 2.2标准方法：为header设置ContentType并修改字符串缓冲区的编码格式
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("<p>李四报道！</p>");
    }
}
