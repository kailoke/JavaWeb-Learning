<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>测试：转发和重定向</title>
</head>
<%--    Servlet:/src/a2_Goto.GotoTest
    转发：Request.dispatcher
    重定向：sendDirect
--%>
<body>
    <h1> <%= request.getAttribute("name")%> 登陆成功!</h1>
</body>
</html>
