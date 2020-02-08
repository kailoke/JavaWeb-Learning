<%@ page import="Listener.a5_BeanHSBindingListener" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/6
  Time: 19:28
  To change this template use File | Settings | File and Code Templates | Other | Jsp files.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>测试HttpSessionBinding</title>
</head>
<body>
<%
  session.setAttribute("name",new a5_BeanHSBindingListener());
%>
</body>
</html>
