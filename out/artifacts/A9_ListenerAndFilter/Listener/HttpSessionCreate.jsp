<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>测试HttpSession创建时机</title>
</head>
<body>
  <h2>测试HttpSession创建时机</h2>
一、.jsp 翻译为 .class(Servlet)文件时 创建内置9个对象<br>

二、改变HttpSessionAttribute
  <%
    session.setAttribute("name","value");
    session.setAttribute("name","va");
    session.removeAttribute("name");
  %>
</body>
</html>
