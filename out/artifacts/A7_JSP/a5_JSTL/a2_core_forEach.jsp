<%@ page import="java.util.*" %>
<%@ page import="com.sun.source.tree.Scope" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>jstl/core:foreach标签</title>
</head>
<%--
一、遍历数组
  > iterate
二、遍历List集合
  > iterate
三、遍历Map集合
  > iterate : entry || entry.key || entry.value
四、range(var,begin,end,step,varStatus)
  > varStatus 遍历信息对象 = "变量名"
    > 属性：index索引  count个数
--%>
<body>
<h1>jstl/core:foreach标签</h1>
<h3>一、foreach遍历数组</h3>
<%
  String[] strings = {"aa","bb","cc"};
  pageContext.setAttribute("arrs",strings);
%>
<c:forEach var="str" items="${ arrs }">
  forEach_[] : ${ str }<br>
</c:forEach>

<h3>二、foreach遍历集合</h3>
<%
  List<String> list = new ArrayList<>(Arrays.asList(strings));
  pageContext.setAttribute("list",list);
%>
<c:forEach var="str" items="${ pageScope.get('list') }">
  forEach_list : ${ str }<br>
</c:forEach>

<h3>三、foreach遍历Map</h3>
<%
  Map<String,Integer> map = new HashMap<>(3);
  map.put(strings[0],0);
  map.put(strings[1],1);
  map.put(strings[2],2);
  pageContext.setAttribute("map",map,PageContext.REQUEST_SCOPE);
%>
<c:forEach var="entry" items="${ map }">
  forEach_key : ${ entry.key }<br>
  forEach_val : ${ entry.value }<br>
  forEach_map : ${ entry }<br><br>
</c:forEach>

<h3>四、forEach的range功能</h3>
<%-- 遍历1-100，每次+2，每遍历3个时输出红色字体 --%>
<c:forEach var="i" begin="1" end="100" step="2" varStatus="status">
  <c:if test="${ status.count % 3 == 0}">
    <font color="#dc143c">${ i }</font>
  </c:if>
  <c:if test="${ status.count %3 != 0}">
    ${ i }
  </c:if>
</c:forEach>
</body>
</html>
