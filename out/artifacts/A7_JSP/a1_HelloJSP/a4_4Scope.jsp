<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>4Scope</title>
</head>
<%--  JSP(pageContext)4个域作用范围
  > PageScope         in page.jsp
  > RequestScope      in request until get response
  > SessionScope      in session exist
  > ApplicationScope  in webApp(服务器启动时创建，WEB项目共享)

一、PageContext的4个域值
  > pageContext增加属性时，(k,v,`int Scope`)设置属性的域
  > pageContext的不同域允许重名的Attribute，getAttribute(k,scope)指明域

二、findAttribute
  > 从pageContext最小域开始查找，找到即返回；否则返回""空String
--%>
<body>
<h1>JSP 4个域的作用范围</h1>
<%
  // PageScope
  pageContext.setAttribute("scope", "PageScope");

  // RequestScope
//  request.setAttribute("scope", "RequestScope");
  pageContext.setAttribute("scope", "RequestScope",PageContext.REQUEST_SCOPE);

  // SessionScope
//  session.setAttribute("scope", "SessionScope");
  pageContext.setAttribute("scope", "SessionScope",PageContext.SESSION_SCOPE);

  // applicationScope
//  application.setAttribute("scope", "ApplicationScope");
  pageContext.setAttribute("scope", "ApplicationScope",PageContext.APPLICATION_SCOPE);
%>
<h2>1.使用不同域对象 从当JSP页面获取值</h2>
<%=pageContext.getAttribute("scope")%><br>
<%=request.getAttribute("scope")%><br>
<%=session.getAttribute("scope")%><br>
<%=application.getAttribute("scope")%><br>

<%--<% // 请求转发--%>
<%--  request.getRequestDispatcher("/HelloJSP/a4_ScopeDispatched.jsp").forward(request,response);%>--%>
<a href="a4_ScopeDispatched.jsp">手动跳转，新的一次请求</a><br><br>

<h2>2.获取pageContext的不同Scope值：getAttribute(name,scope)</h2>
<%=pageContext.getAttribute("scope")%><br>
<%=pageContext.getAttribute("scope",PageContext.REQUEST_SCOPE)%><br>
<%=pageContext.getAttribute("scope",PageContext.SESSION_SCOPE)%><br>
<%=pageContext.getAttribute("scope",PageContext.APPLICATION_SCOPE)%><br><br>

<h2>3.findAttribute，从最小域逐步查找，查找到任意匹配则返回</h2>
<%= pageContext.findAttribute("scope") %>
</body>
</html>
