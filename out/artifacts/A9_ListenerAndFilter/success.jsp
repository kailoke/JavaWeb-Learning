<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
    成功登陆的提示页面
--%>
<body>
    <h1>登陆成功！</h1>
    <h2>欢迎，${ sessionScope.userExist.nickname }</h2>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>