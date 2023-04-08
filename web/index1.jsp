<%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/8
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  这是第一个jsp页面
<% //System.out.println("控制台打印");
   //System.out.printf("req =" + request,"resp =" + response);
   String s = "控制台打印还是页面打印";
%>
  <% out.print("abcd"); %>
  <h1><%=s%>{s}</h1>
  </body>
</html>
