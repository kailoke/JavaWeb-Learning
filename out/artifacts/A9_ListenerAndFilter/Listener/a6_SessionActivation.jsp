<%@ page import="Listener.a6_BeanSessionActivation" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>测试HttpSessionActivationListener</title>
</head>
<body>
<h1> Java类实现HttpSessionBindingListener，<br>
  使其对象感知在Session中的 序列化/加载 状态</h1>
<%
  a6_BeanSessionActivation bean = new a6_BeanSessionActivation();
  bean.setName("张三");
  session.setAttribute("name",bean);
%>
</body>
</html>
