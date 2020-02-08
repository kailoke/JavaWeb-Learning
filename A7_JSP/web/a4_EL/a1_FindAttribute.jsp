<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>EL findScope数据(域对象)</title>
</head>
<%--
EL获取数据，调用pageContext.findAttribute()
  一、指定Scope.name，实际调用 xxxScope.get(Object key)
    > pangeContext.getAttr == pageScope.name
    > request.getAttr      == requestScope.name
    > session.getAttr      == sessionScope.name
    > application.getAttr  == applicationScope.name

  二、简写：${name}。省略Scope域对象的调用
    > 1.从最小Scope查找，找到则返回；否则返回空字符串(html并不会显示)
    > 2.若是域对象获取数据，找不到返回"null"

  三、获取数组(动态数组)数据： arr[index]索引方式获取
  四、获取Map数据
    > value : map["key"](key中包含特殊字符) || map.key
--%>
<body>
<h1>EL findXxxScope数据</h1>
<%
//  pageContext.setAttribute("name","page");
  request.setAttribute("name","request");
  session.setAttribute("name","session");
  application.setAttribute("name","application");
%>
<h4> 域对象.get - EL表达式获取</h4>
<div><%=pageContext.getAttribute("name")%> - ${pageScope.name}</div>
<div><%=request.getAttribute("name")%> - ${requestScope.name}</div>
<div><%=session.getAttribute("name")%> - ${sessionScope.name}</div>
<div><%=application.getAttribute("name")%> - ${applicationScope.name}</div>

<h4> EL 简写</h4>
<div>${name}</div>

<h1>EL 获取数组数据</h1>
<%
  String[] strings = {"aa","bb","cc"};
  pageContext.setAttribute("arr",strings);
%>
${arr[0]}
${arr[1]}
${arr[2]}

<h1>EL 获取List集合数据</h1>
<%
  List<String> list = new ArrayList<>(Arrays.asList(strings));
  pageContext.setAttribute("list",list);
%>
${list[0]}
${list[1]}
${list[2]}

<h1>EL 获取Map集合数据</h1>
<%
  Map<String,Integer> map = new HashMap<>();
  map.put("aa",123);
  map.put("bb.b",234);
  map.put("cc.cc",345);
  pageContext.setAttribute("map",map);
%>
${map.aa}
${map["bb.b"]}
${map["cc.cc"]}

</body>
</html>
