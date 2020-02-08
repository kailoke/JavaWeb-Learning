<%-- 登录界面 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>登录界面</title>
</head>
<body>
<h1>登录页面</h1>
<h5>使用Filter拦截用户未登录时的非法请求</h5>
<div style="color:crimson ">${ requestScope.msg }</div>

<form action="${pageContext.request.contextPath}/login" method="post">
  <table>
    <tr>
      <th>用户名：</th>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <th>密码：</th>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="登录"></td>
    </tr>
  </table>
</form>
</body>
</html>
