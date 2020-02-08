package Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filter入门案例
 * > implements javax.servlet.Filter
 * > xml配置过滤器，同JSP。<url-pattern>.innerHTML = 拦截路径
 */
public class a0_HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter0 initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter0 执行过滤~~!");

        // filterChain.doFilter对请求放行，否则请求被拦截
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter0 执行doFilter()结束");
    }

    @Override
    public void destroy() {
    }
}
