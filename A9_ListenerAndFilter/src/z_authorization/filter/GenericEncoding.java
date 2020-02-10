package z_authorization.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 通用的字符集编码过滤器，解决中文乱码问题
 */
public class GenericEncoding  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    // 增强Request对象传递给Servlet
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Encoding encoding = new Encoding(request);
        System.out.println("放行增强后的Request对象");
        filterChain.doFilter(encoding,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

/**
 * HttpServletRequestWrapper：HttpServletRequest的包装类(模板类)
 *  > 内部继承HSRequest，重写所有方法(调用父类方法)
 *  > 自定义类继承HSRequest，重写需要增强的方法，将重写后的增强请求对象放行
 */
class Encoding extends HttpServletRequestWrapper {
    // 维护原始请求对象
    private HttpServletRequest request;
    Encoding(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    @Override
    // 重写 getParameter
    public String getParameter(String name) {
        // get
        if ("get".equalsIgnoreCase(this.request.getMethod())){
            try {
                return URLDecoder.decode(super.getParameter(name), String.valueOf(StandardCharsets.UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // post
        } else if ("post".equalsIgnoreCase(this.request.getMethod())){
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return super.getParameter(name);
    }
}
