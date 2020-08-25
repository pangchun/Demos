<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/7/15
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎登录</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">

      用户名<input type="text" name="username" value="${username}">
      密码<input type="password" name="password" value="${password}"> <br>
      记住密码<input type="checkbox" name="autoLogin"> <br>
      <button type="submit">登录</button>
      <button type="reset">取消</button>
    </form>
  </body>
</html>
