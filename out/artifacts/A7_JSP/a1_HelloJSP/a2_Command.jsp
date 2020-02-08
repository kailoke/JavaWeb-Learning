<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<%--  指令语法 <%@ 指令 field=value fiela2=value ... %>

一、page：定义JSP文件的全局属性
  >! 在JSP页面中，只有<%@ import %>属性可以出现多次：导入java包或类
    ** 其他属性最多只能出现一次
  >! contentType   JSP被浏览器解析用的字符集
  >! pageEncoding  JSP及其Servlet持久化时的编码格式

  > language  声明脚本使用的程序语言，默认"java"
  > extends   JSP编译为Servlet时继承的类，默认"HttpJspBase"
  > session   是否允许JSP直接使用session对象，默认"true"
  > buffer    JSP对客户端输出缓冲区大小，默认"8kb"。  同Buffered_IO_Stream,8k
  > autoFlush 如果buffer溢出，是否自动刷新，默认"true"

  > isErrorPage 默认"false"。指明为"true"的页面可以使用 exception.getMessage()显示错误信息
  > errorPage   当前JSP页面发生异常后的处理：errorPage="error.jsp":(服务器正在维护！)

  > isELIgnored 默认"false"。JSP是否忽略EL表达式 ${ Exp }。若忽略则当成html文本


二、include：定义JSP"静态"包含的文件，并由该JSP解析包含的文件内容；
  >! file 包含文件的路径
  > 主文件的变量，可以在被包含文件中使用(静态包含)
  > 代码拷贝(copy)实现页面重用， .jsp->.java(Servlet)->.class
  > 将被包含的文件的"非内容结构"去除


三、taglib：引入标签库
  > uri     标签库的路径
  > prefix  引入标签库的别名(as)



--%>
<body>

</body>
</html>
