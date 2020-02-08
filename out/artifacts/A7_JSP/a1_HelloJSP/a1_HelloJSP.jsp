<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hello JSP</title>
    <style>
        .keyWord{
            font-size: large;
            color: crimson
        }

    </style>
</head>
<%--
  一、JSP运行原理：翻译为Servlet后执行
    1.访问WebServer(此处是Tomcat)
    2.查找请求行文件：Xxx.jsp
    3.将查找到的Xxx.jsp翻译为Xxx_jsp.java(Servlet) 存放至"work/Catalina/(host-name)/
    4.Xxx_jsp.java 编译为 Xxx_jsp.class            ↑↑同目录
    5.执行 Xxx.class

  二、动态网页开发模式(MVC思想)： Servlet + JSP + JavaBean
    1.Controller：Servlet控制调度
    2.Model ：JavaBean封装(domain)和处理(model)数据
    3.View  ：JSP显示数据非常方便
--%>
<%--
  变量 或 方法 声明及使用
    一、声明标签      <%! %>  类成员\类方法
    二、代码标签      <% %>   service()内代码
    三、表达式标签    <%= %>  out.printl()参数 in service()
--%>
<body>
    <h1>Declare Field</h1>
    <h2>一、声明标签：&lt%! <span class="keyWord">Field to Servlet</span> %&gt声明</h2>
    <%!
        // 声明为Servlet类的 MemberField || MemberFunction
        private int i = 3;
    %>

    <h2>二、代码标签：&lt% <span class="keyWord">Statements to service()</span> %&gt</h2>
    <%
        // 程序代码，service()内的代码片段
        int j = 5;
    %>

    <h2>三、表达式标签：&lt%= <span class="keyWord">Content to out.print()</span> %&gt</h2>
    <%=
        // 表达式中的内容作为 out.print() [in service()]的参数
        i + j + "<br/>"
    %>
    <%=
        j
    %>
</body>
</html>
