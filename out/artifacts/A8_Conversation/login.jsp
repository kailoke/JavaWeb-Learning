<%@ page import="A3_LoginExercise.utils.Verification" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录测试</title>
</head>
<%--
    使用 username,password,verificationCode登陆
    将成功登陆的用户信息保存至Session中(记住密码)
--%>
<body>
    <h1>登录测试页面</h1>
    <%-- 输出登陆错误信息 --%>
    <h3 style="color: crimson">${ requestScope.msg }</h3>

    <div>
        <form action="/Conversation/login" method="get">
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username" value="${cookie.username.value}"/><br/>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password"/><br/>

            <label for="verificationCode">验证码：</label>
            <input type="text" id="verificationCode" name="verificationCode" maxlength="4" size="3">

            <%-- 生成验证码 --%>
            <%
                String verificationCode = Verification.getV();
                session.setAttribute("verificationCode",verificationCode);
                System.out.println("VerificationCode generate: " + verificationCode);
            %>
            <%--显示验证码--%>
            <span id="code" style="border: 1px black solid; background-color: peru; color: crimson">
                <%= session.getAttribute("verificationCode")%>
            </span>
            <!-- 点击刷新验证码 -->
            <a href="" onclick="">看不清，换一张</a> <br>

            <input type="checkbox" id="rememberMe" name="rememberMe" value="true">
            <label for="rememberMe">记住密码</label><br>

            <input type="submit" value="登录" />
        </form>
    </div>
</body>
</html>
