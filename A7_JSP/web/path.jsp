<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<%-- 路径问题：推荐使用绝对路径
    访问Sevlet:a1_ClientPathAndServerPath.ServletPathDemo
--%>
<body>
    <h1>路径问题</h1>
    <h2>相对路径：项目根目录文件访问Servlet</h2>
    <a href="ServletPathDemo">相对路径访问1 a1_ClientPathAndServerPath.ServletPathDemo</a><br>
    <a href="./ServletPathDemo">相对路径访问2 a1_ClientPathAndServerPath.ServletPathDemo</a>

    <h2>绝对路径：项目根目录文件访问Servlet</h2>
    <a href="http://localhost:8080/JSP/ServletPathDemo">绝对路径访问1 a1_ClientPathAndServerPath.ServletPathDemo</a><br/>
    <a href="/JSP/ServletPathDemo">绝对路径访问2 a1_ClientPathAndServerPath.ServletPathDemo</a>
</body>
</html>
