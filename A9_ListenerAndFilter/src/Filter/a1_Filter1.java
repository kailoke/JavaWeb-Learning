package Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * FilterChain：一个WebApp可以拥有多个filter构成filterChain
 * 一、执行顺序：      --test:注册顺序 filter0-filter2-filter1
 *  > 1. 按<filter-mapping>注册顺序执行，直到目标资源
 *  > 2. 目标资源响应后逆序执行(方法压栈)filter至客户端
 *
 * 二、生命周期
 *  > 创建：WebServer启动时，创建所有filter对象，并执行filter.init()
 *      > 只创建一次，只执行一次
 *  > 执行：filter监听<url-pattern>，触发则执行 filter.doFilter()
 *  > 销毁：移除应用，关闭服务器
 */
public class a1_Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter1 initialized()...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1 执行过滤 ~~!");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter1 执行doFilter()结束");
    }

    @Override
    public void destroy() {
        System.out.println("filter1 destroyed...");
    }
}
