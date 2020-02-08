<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>9个 JPS内置对象</title>
</head>
<%--  JSP内置9对象：可以直接在JSP页面中使用的对象
  > config      ServletConfig     当前JSP的ServletConfig对象
  > application ServletContext    代表应用，一个web应用一个ServletContext对象

  > request   HttpServletRequest  客户端发送的请求对象
  > response  HttpServletResponse 服务器发送的响应对象
  > session   HttpSession         服务器为客户端创建的会话对象

  > page(this)  (lang)Object=this 当前JSP翻译成Servlet后的对象的引用
  > pageContext PageContext       JSP页面的上下文对象，每个JSP页面独有

  > out         JspWriter         向输出流写入内容的对象
  > exception   Throwable         JSP页面运行时异常对象
  * 内置对象会在 jspService()方法中创建

pageContext对象是javax.servlet.jsp.PageContext类的实例
一、作用：
  > 1. 在page范围内作为域对象存取数据(Attribute)，拥有4个Scope属性
    > findAttribute(String name) 查找属性
  > 2. 通过pageContext对象获得其他8个内置对象
    > getXxx()
--%>
<body>

</body>
</html>
