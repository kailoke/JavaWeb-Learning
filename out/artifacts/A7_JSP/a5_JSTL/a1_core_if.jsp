<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>JSTL/core:if标签</title>
</head>
<%--
  jstl/core:if
    > test(required)
    > var = test()
    > scope = var变量存储域对象
--%>
<body>
<h1>jstl/core:if标签</h1>
<c:set var="name" value="9" scope="page"></c:set>
<c:if var="result" test="${name >= 10}">
  <h4 style="color: greenyellow"> name >= 10 </h4>
  var result = ${ result }
</c:if>
<c:if test="${name < 10}" >
  <h4 style="color: crimson"> name < 10 </h4>
</c:if>
</body>
</html>
