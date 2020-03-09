package a1_Filter;

import javax.servlet.*;
import java.io.IOException;

/** Filter
 * 一、使用流程
 *  > implements javax.servlet.Filter
 *  > xml配置过滤器，同JSP。<url-pattern>.innerHTML = 拦截路径
 *
 * 二、Filter生命周期
 *  > init()：WebServer启动时，创建所有filter对象，并执行所有filter.init()
 *      > 只创建一次，只执行一次
 *  > doFilter()：filter监听<url-pattern>，触发则执行 filter.doFilter()
 *  > destroy()：移除应用，关闭服务器时执行销毁方法
 *
 * 三、FilterChain：一个WebApp可以拥有多个filter构成filterChain
 *  > 1. 注册顺序 filter0-filter2-filter1
 *  > 2. 按<filter-mapping>注册顺序执行，直到目标资源
 *  > 3. 目标资源响应后逆序执行(方法压栈)filter至客户端
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
