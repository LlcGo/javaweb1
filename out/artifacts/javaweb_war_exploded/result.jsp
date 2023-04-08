<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/8
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String username = request.getParameter("username");
    String password = request.getParameter("password");
    String job = request.getParameter("job");
    String range = request.getParameter("range");
    String age = request.getParameter("age");
    String mail = request.getParameter("mail");
    String salary = request.getParameter("salary");
    String[] hobbies = request.getParameterValues("hobbies");
%>
<h1>用户名是<%=username%></h1>
<h1>密码是<%=password%></h1>
<h1>职业是<%=job%></h1>
<h1>范围是<%=range%></h1>
<h1>年龄是<%=age%></h1>
<h1>电子邮箱是<%=mail%></h1>
<h1>薪资是<%=salary%></h1>
<h1>兴趣爱好是
    <%
    for (int i = 0; i <hobbies.length; i++){
        out.print(hobbies[i]+" ");
    }%>
    </h1>
</body>
</html>
