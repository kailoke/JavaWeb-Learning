package A1_Cookie;

/** Cookie 小型文本文件
 * 一、键值对构成，一个Cookie用于标识一种信息
 * 二、浏览器Cookie大小<=4K，每个站点最多存放20个，总共300个
 * 三、常用方法：
 *  > 1.构造方法： Cookie(String name,String value)
 *  > 2.获取值
 *      > getName()
 *      > getValue()
 *  > 3.其他方法
 *      > setDomain(String pattern) 有效域名及其子域名下携带Cookie
 *      > setPath(String url)       有效路径及其子路径下携带Cookie
 *      > setMaxAge（int expiryMillis)    expires有效期，默认为会话时长
 *  > 4.清除Cookie
 *      > Path一致的Cookie，设置其MaxAge=0
 */

public class CookieAPI {
}
