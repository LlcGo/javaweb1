<%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/8
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<%String username = request.getParameter("username");%>
<h1>欢迎<%=username%>登录</h1>
</body>
</html>
