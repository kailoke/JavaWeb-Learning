package a1_Filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/** FilterConfig
 * 一、作用：服务器创建时传入init()方法
    > 获得Filter配置信息
    > 和 javax.servlet.Servlet -- ServletConfig 机制相同
 * 二、常用方法
 * > String getFilterName()
 * > String getInitParameter(String name)
 * > Enumeration getInitParameterNames()
 * > ServletContext getServletContext() 基本都可以获得context对象
 */
public class a2_FilterConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterName = filterConfig.getFilterName();
        System.out.println("filterConfig.getFilterName(): " + filterName);

        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        System.out.println("filterConfig.getInitParameterNames(): " + initParameterNames);

        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = filterConfig.getInitParameter(name);
            System.out.println("filterConfig." + name + ": " + value);
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterConfig do filter...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
