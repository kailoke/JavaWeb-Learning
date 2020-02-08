package z_authorization.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 权限验证
 */

public class authorization implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 登陆验证
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object userExist = request.getSession().getAttribute("userExist");
        if (userExist == null) {    // 未登录
            request.setAttribute("msg","请先进行登陆!");
            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
        }else{
            filterChain.doFilter(request,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
