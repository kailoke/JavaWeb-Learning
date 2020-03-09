package a2_Listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/** Bean for testing HttpSessionActivationListener
 * 一、作用：使JavaBean类感知对象在HttpSession中的 序列化/加载 状态
 *  > Bean需要实现Serializable接口才能序列化
 *  > Bean存储于session中，随着session 序列化 || 加载
 *  > activate      活化(session) didActivate()
 *  > passivate     钝化(session) willPassivate()
 *
 * 二、流程：事件源主动绑定监听器，HSAL比较特殊只需要在类中声明
 *  > 配置META-INF/context.xml，使得session-timeout自动序列化。
 *    maxIdleSwap 闲置转换时间(分)
 *  <Context>
 *      <Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
 *          <Store className="org.apache.catalina.session.FileStore" directory="/path" />
 *      </Manager>
 *  </Context>
 */

public class a6_BeanSessionActivation implements HttpSessionActivationListener, Serializable {
    private static final long serialVersionUID = 1153248633L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("Bean in session will passivate");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("Bean in session did activate");
    }
}
