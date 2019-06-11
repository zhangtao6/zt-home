<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/29
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--引入bootstrap样式-->
    <link rel="stylesheet" type="text/css" href="../../plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css" />

    <!--站点图标-->
    <link rel="shortcut icon" type="image/x-icon" href='../../img/favicon.ico' />
    <style>
        body {
            background-image: url('../../img/login.jpg') ;
        }
        .container-fluid>.row>.form-horizontal{
            padding-top: 20%;

        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-5  col-sm-2" style="color: red; margin-top: 270px">
            <%=request.getAttribute("error")==null?"":request.getAttribute("error") %>
        </div>
        <form class="form-horizontal" action="/login" method="post">
            <div class="form-group">

                <div class="col-sm-offset-5  col-sm-2">
                    <input type="text" class="form-control" id="username"  name="username" placeholder="username">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-5  col-sm-2">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-5 col-sm-2">
                    <button type="submit" class="btn btn-info col-sm-12" >Sign in</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    /*$(".btn").click(function () {
        //读取用户的输入
        var username = $("#username").val();
        var password = $("#password").val();
        //异步提交请求，进行验证
        $.ajax({
            url:"/login",
            type:"post",
            data:"username=" + username + "&password=" + password,
            dataType:"json",
            success:function(result){
            }

        })
        location.href='addressAdmin.html';
    })*/
</script>
<!--引入jquery-->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!--引入bootstrap.min.js-->
<script src="../../plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
