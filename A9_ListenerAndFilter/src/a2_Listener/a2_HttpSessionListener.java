package a2_Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/** HttpSessionListener
 * 一、作用：监听HttpSession对象的创建和销毁
 *  > 创建：服务器"第一次"调用 request.getSession()
 *      > 访问.jsp时服务器会创建所有JSP8个内置对象
 *  > 销毁：
 *      > 1. session-timeout，tomcat默认30分钟，单位为分钟
 *      > 2. invalidate()，手动销毁
 *      > 3. 非正常关闭丢失对象；正常关闭则序列化至work
 */
public class a2_HttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession destroyed");
    }
}
