package Listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/** Bean for testing HttpSessionBindingListener
 * 一、作用：使JavaBean类自己感知自身在HttpSession中的绑定状态
 *  > bound         绑定(session)
 *  > unbound       解绑(session)
 *
 * 二、流程：事件源主动绑定监听器，HSBL比较特殊只需要在类中声明
 */

public class a5_BeanSessionBinding implements HttpSessionBindingListener {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Bean bound to session");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Bean unbound from session");
    }
}
