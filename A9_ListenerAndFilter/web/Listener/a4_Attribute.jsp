<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/6
  Time: 19:14
  To change this template use File | Settings | File and Code Templates | Other | Jsp files.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>改变HttpSessionAttribute</title>
</head>
<body>
<h1>改变HttpSessionAttribute</h1>
<%
  session.setAttribute("name","value");
  session.setAttribute("name","va");
  session.removeAttribute("name");
%>
</body>
</html>
