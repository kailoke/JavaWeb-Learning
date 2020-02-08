<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<%-- 路径问题：
    非根目录访问 a1_ClientPathAndServerPath.ServletPathDemo
    返回上级目录："../"
--%>
<body>
    <h1>路径问题</h1>
    <h2>相对路径：项目非根目录文件访问Servlet</h2>
    <a href="../ServletPathDemo">相对路径访问1ServletPathDemo</a>

    <h2>绝对路径：项目非根目录文件访问Servlet</h2>
    <a href="http://localhost:8080/JSP/ServletPathDemo">绝对路径访问1 a1_ClientPathAndServerPath.ServletPathDemo</a><br/>
    <a href="/JSP/ServletPathDemo">绝对路径访问2 a1_ClientPathAndServerPath.ServletPathDemo</a>
</body>
</html>
