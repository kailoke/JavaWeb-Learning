package a1_Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * filterChain测试类2
 */

public class a1_Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter2 执行过滤 ~~!");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter2 执行doFilter()结束");
    }

    @Override
    public void destroy() {
        System.out.println("filter2 destroyed");
    }
}
