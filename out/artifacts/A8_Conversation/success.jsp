<%@ page import="A3_LoginExercise.domain.User_table" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
    成功登陆的提示页面
--%>
<body>
    <%
        if (session.getAttribute("userExist") == null){
    %>
            <h1>您还未登陆，请先进行<a href="${pageContext.request.contextPath}/login.jsp">登陆</a>!</h1>
    <%
        } else {
            User_table user = (User_table)session.getAttribute("userExist");
            String nickname = user.getNickname();
    %>
            <h1>登陆成功！</h1>
            <h2>你好，<%=nickname%>。</h2>
            <a href="${pageContext.request.contextPath}/logout">退出</a>
    <%
        }
    %>
</body>
</html>