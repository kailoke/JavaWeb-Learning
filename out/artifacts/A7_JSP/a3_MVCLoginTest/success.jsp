<%@ page import="a3_MVCLoginTest.controller.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
    login.jsp 成功验证登陆后跳转到此页面
    显示历史成功登陆人数
--%>
<body>
    <h1> <%= this.getServletConfig().getServletContext().getAttribute("nickname")%> 欢迎!</h1>
    <h3> <%= this.getServletConfig().getServletContext().getAttribute("count")%> 人已成功登陆!</h3>
    <h3> <%= LoginServlet.loginCount %> 人已成功登陆!</h3>
</body>
</html>
