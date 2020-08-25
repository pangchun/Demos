<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/7/16
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎登录</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/LoginServlet" method="post">

    用户名<input type="text" name="username"> <br>
    密码<input type="password" name="password"> <br>
    验证码<input type="text" name="randomNum">

      <img id="image" src="${pageContext.request.contextPath}/ImageServlet" onclick="this.src='${pageContext.request.contextPath}/ImageServlet?d='+Math.random();"> <br>

    <input type="submit" value="提交">

  </form>

  </body>
</html>
