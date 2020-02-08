package Listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * ServletContextAttributeListener
 * ServletRequestAttributeListener
 * HttpSessionAttributeListener
 * 一、作用：监听三个域对象的Attribute属性发生改变(增、删、改)
 *  > 增 add
 *  > 删 remove
 *  > 改 replace
 */
public class a4_AttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttribute added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttribute Removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttribute Replaced");
    }
}
