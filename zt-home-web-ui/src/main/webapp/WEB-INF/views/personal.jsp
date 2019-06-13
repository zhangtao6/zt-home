<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/6/13
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>introduce</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--引入bootstrap样式-->
    <link rel="stylesheet" type="text/css" href="/static/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/static/css/introduce.css" />

    <!--站点图标-->
    <link rel="shortcut icon" type="image/x-icon" href='/static/img/favicon.ico' />
</head>

<body>
<!--头部-->
<header id="lk_header">
    <jsp:include page="../includes/nav.jsp"/>

<!--身体-->

<!--顶部空白-->
<div style="width: 100%; height: 100px;background-color: #F5F7F9;">
</div>
<!--顶部空白-->

<div class="row">
    <div class="col-sm-12 body-content" >
        ${tbContent.introduction}
    </div>
    <div class="col-sm-offset-2 col-sm-8  body-content-text" >
        <%--<img src="../img/introduce.jpg" />

        <p>姓名： flyingmylife</p>
        <p>邮箱： 1459602548@qq.com</p>
        <p>Github：	https://github.com/smallsnail-wh</p>
        <p>简介： 90后，主要从事java开发，喜欢研究新东西，爱好打篮球、敲代码，做事认真无论是玩还是学习。</p>--%>
        ${tbContent.details}
    </div>
</div>

<!--身体-->

<!--尾部-->
<div class="row">
    <div style="width: 100%; height: 40px;background-color: #F5F7F9; margin-top: 40px;">
    </div>
    <div class="col-sm-12 foot-img">
        <img src="/static/img/GitHub-Mark-32px.png"/>
    </div>
    <div class="col-sm-12 foot-font">
        2018-2020 	&copy; flyingmylife
    </div>
</div>
<!--尾部-->
<!--引入jquery-->
<script src="/static/plugins/jquery/jquery.min.js"></script>
<!--引入bootstrap.min.js-->
<script src="/static/plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/static/js/home.js"></script>
</body>
</html>
