<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>method='get'</h1>
<form action="${pageContext.request.contextPath}/charSet">
  姓名：<input type="text" name="name"/><br>
  <input type="submit" value="提交">
</form>


<h1>method='post'</h1>
<form action="${pageContext.request.contextPath}/charSet" method="post">
  姓名：<input type="text" name="name"/><br>
  <input type="submit" value="提交">
</form>

</body>
</html>
