<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/7/12
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>

    <%--引入jQuary--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>

    <%--利用ajax提交表单--%>
    <script type="text/javascript">
        $(function () {

          /*点击提交按钮事件*/
          $("#submitBtn").click(function () {

            var name = $("#name").val();
            var password = $("#password").val();

            if (name ==='') {

              alert("名字不能为空");

            }else if (password ==='') {

              alert("密码不能为空");

            }else {

              //提交用户的登录表单信息
              $.ajax({
                type:"post",
                url:"MyServlet_2",
                data:{name:name,password:password},
                dataType:"json",
                success:function (data) {
                  if (data.success){
                    window.location.href = "${pageContext.request.contextPath}/MyServlet_3";
                  }else {
                    alert("密码有误");
                  }
                }
              })
            }
          })
        })
    </script>

  </head>
  <body>

  <form action="#" id="form" method="post">
    名字：小妲己 密码：123 <br>
    名字<input type="text" name="name" id="name"> <br>
    密码<input type="password" name="password" id="password"> <br>
    <button type="submit" id="submitBtn">提交</button> <br>
  </form>

  </body>
</html>
