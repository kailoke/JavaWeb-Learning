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
    <a href="${pageContext.request.contextPath}/logout">退出</a><br>
  <a href="${pageContext.request.contextPath}/jsp/sub.jsp"> 提交数据，进行字符集编码过滤 </a>
</body>
</html>