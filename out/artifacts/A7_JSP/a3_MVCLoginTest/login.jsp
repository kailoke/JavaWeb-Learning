<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登陆测试</title>
</head>
<%--
    模拟用户登陆
    输入用户名和密码，提交后与数据库中信息匹配
        成功则跳转至成功登陆的页面，显示历史成功登陆人数
        失败则仍在登陆页面，给出提示信息
--%>
<body>
<%
    String msg = "";
    if(request.getAttribute("msg") != null ) {
        msg = (String) request.getAttribute("msg");
    }
%>
    <h1>登陆测试页面</h1>
    <%-- 输出登陆错误信息 --%>
    <h3 style="color: crimson"><%= msg %></h3>
    <div>
        <form action="/JSP/login" method="post">
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username" /><br/>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password"/><br/>

            <input type="submit" value="登陆" />
        </form>
    </div>
</body>
</html>
