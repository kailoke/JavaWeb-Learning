<%--
  User: Administrator
  Date: 2020/2/6
  Time: 9:48
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>EL 运算</title>
</head>
<%--
  一、算术运算
  二、比较(关系)运算：
    <     lt    EL使用html字体实体可省略 &
    >     gt
    =     eq
    <=    le
    >=    ge
    !=    ne
  三、逻辑运算
    &&    and
    ||    or
    !     not
    ? : 三目运算
  四、为空运算符，判断对象是否为空
    empty Object
--%>
<body>
<h1>一、EL 算术运算</h1>
<%
  pageContext.setAttribute("a",2);
  pageContext.setAttribute("b","10");
  pageContext.setAttribute("c",5);
  pageContext.setAttribute("d","9");
%>
a+b=EL:${ a + b}

<h1>二、关系(比较)运算</h1>
a&ltb=EL:${ a < b }<br>
a greater b = EL:${ a gt b }

<h1>三、逻辑运算</h1>
  a &lt b && c &gt d = EL : ${ a < b && c > d}<br>
  a &lt b && c &lt d = EL : ${ a lt b and c lt d}

<h1>四、EL 空判断</h1>
  ${ empty user} <%-- 判断对象是否为空，not empty非空判断 --%>
</body>
</html>
