<%@ page import="Listener.a5_BeanSessionBinding" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>测试HttpSessionBindingListener</title>
</head>
<body>
<h1> Java类实现HttpSessionBindingListener，<br>
  使其对象感知在Session中的 bound/unbound 状态</h1>
<%
  session.setAttribute("name",new a5_BeanSessionBinding());
  session.setAttribute("name",1);
//  session.removeAttribute("name");
%>
</body>
</html>
