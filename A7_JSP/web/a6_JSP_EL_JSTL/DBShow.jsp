<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<%--
  显示 controller:a4_JSP_EL_JSTL.NameCheck.ServletShowDB 结果(请求转发)
--%>
<body>
<h1>查询结果：
  <c:if test="${not empty list}">
  true
  </c:if>
</h1>

<table border="2px">
  <tr>  <!-- 标题行 -->
    <th>user</th>
    <th>password</th>
    <th>nickname</th>
  </tr>

  <c:forEach var="user" items="${list}">
  <tr>
    <td align="center">${user.user}</td>
    <td align="center">${user.password}</td>
    <td align="center">${user.nickname}</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
