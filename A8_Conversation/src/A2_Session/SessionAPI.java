package A2_Session;

/** Session 域对象
 * 一、Session将用户数据存放至服务器(安全)，一个浏览器独占一个Session实例。使用服务器资源
 *
 * 二、工作流程
 *  > 获取:依赖Request的Session实例：Request.getSession()
 *  > set:Session域对象setAttribute(name,value)
 *  > get:Session域对象getAttribute(name)
 *
 * 三、Session实现原理：基于Cookie，回写SessionID
 *  > response将SessionID写入Cookie
 *  > request携带Cookie:SessionID访问
 *
 * 四、Session作用范围：一次会话
 *  > 客户端开始访问服务器，至客户端关闭
 *
 * 五、Session对象生命周期
 *  > 创建：服务器第一次调用getSession()创建HttpSession实例
 *  > 销毁： 1.session-timeout，tomcat默认30分钟
 *          2.非正常关闭服务器。(正常关闭则序列化至/work)
 *          3.调用 session.invalidate() 使无效
 */

public class SessionAPI {
}
