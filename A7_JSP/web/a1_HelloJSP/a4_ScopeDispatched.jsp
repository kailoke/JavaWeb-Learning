<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>ScopeDispatched.jsp</title>
</head>
<body>
<h2>获取转发 之前 的JSP域对象值</h2>
<%=pageContext.getAttribute("scope")%><br>
<%=request.getAttribute("scope")%><br>
<%=session.getAttribute("scope")%><br>
<%=application.getAttribute("scope")%><br>
</body>
</html>
