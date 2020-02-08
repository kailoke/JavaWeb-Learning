<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/6
  Time: 10:30
  To change this template use File | Settings | File and Code Templates | Other | Jsp files.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>11个EL WEB常用开发对象</title>
</head>
<%--
EL 常用对象
  > pageContext
    > 相当于JSP的pageContext对象，获取其他JSP对象
    > 拥有4个域存储区域
  > 4Scope： pageScope requestScope sessionScope applicationScope
    > 获取指定域的name-value
  > param
    > 获取请求参数[k]       ~= request.getParameter()
  > paramValues
    > 获取请求参数数组[k]   ~= request.getParameters()返回数组对象
    > *注意ParamValues.name返回的是数组对象
  > header
    > 获取请求头信息[k]      ~= request.getHeader()
  > headerValues
    > 获取请求头信息数组[k]  ~= request.getHeaders()返回枚举对象
  > cookie
    > 获取cookie键值对：cookie["key"]["value"] || cookie.key.value
  > initParam
    > 获取<context-param>/<param-name><param-value>
--%>
<body>

<h1>param:获取请求参数(k,v)</h1>
<h5>get请求携带 name 参数访问!!</h5>
param.name : ${ param.name }<br>
paramValues.name : ${ paramValues.hobby }<br>
paramValues.name[0] : ${ paramValues.hobby[0] }<br>
paramValues.name[1] : ${ paramValues.hobby[1] }<br>

<h1>header:获取请求头信息</h1>
header["User-Agent"] : ${ header["User-Agent"] }

<h1>cookie:获取cookie键值对</h1>
cookie.key.name : ${ cookie.JSESSIONID.value }<br>
cookie["key"]["name"] : ${ cookie["JSESSIONID"]["value"] }

<h1>pageContext:获取JSP对象</h1>
pageContext.request.contextPath : ${ pageContext.request.contextPath }
</body>
</html>
