package a2_Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/** ServletRequestListener
 * 一、作用：监听ServletRequest对象的创建和销毁
 *  > 创建：客户端向服务器发送请求，服务器接收到请求则创建Request对象
 *  > 销毁：服务器对某个Request对象完成响应后，销毁该对象
 *
 */
public class a3_ServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request initialized");
    }
}
