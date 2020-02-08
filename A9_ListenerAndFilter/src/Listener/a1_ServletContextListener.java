package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** ServletContextListener
 * 一、作用：监听ServletContext对象的创建和销毁
 *  > 创建：webApp deployed
 *  > 销毁：webApp un-deployed (before ServerShutDown)
 * 二、web.xml注册监听器 <listener> : <listener-class>
 *
 * 三、应用
 *  > 框架加载配置文件
 *      > Spring核心监听器：ContextLoaderListener implements ServletContextListener
 *  > 定时任务调度：服务器启动后 注册时间相关的事件
 */
public class a1_ServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener:ServletContext Object has been initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener:ServletContext Object has been destroyed");
    }
}
