package A0_CookieUtils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookie(Cookie[] cookies, String name) {
        // Browser没有Cookie
        if (cookies == null){
            return null;
        }

        // Browser有Cookie
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                System.out.println("return cookie: " + cookie.getName());
                return cookie;
            }
        }
        // 未找到Key
        return null;
    }
}
