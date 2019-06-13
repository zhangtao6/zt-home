<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/6/13
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>home</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--引入bootstrap样式-->
    <link rel="stylesheet" type="text/css" href="/static/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/static/css/home.css" />

    <!--站点图标-->
    <link rel="shortcut icon" type="image/x-icon" href='/static/img/favicon.ico' />
</head>

<body>
<jsp:include page="../includes/nav.jsp"/>

<!--轮播图-->
<section id="lk_carousel" class="carousel slide" data-ride="carousel">
    <!-- 指示器 -->
    <ol class="carousel-indicators">
        <li data-target="#lk_carousel" data-slide-to="0" class="active"></li>
        <li data-target="#lk_carousel" data-slide-to="1"></li>
        <li data-target="#lk_carousel" data-slide-to="2"></li>
        <li data-target="#lk_carousel" data-slide-to="3"></li>
    </ol>

    <!-- 滚动内容 -->
    <div class="carousel-inner" role="listbox">
        <div class="item active" data-lg-img="../img/lb1.jpg" style="background-image: url(/static/img/lb1.jpg);">
        </div>
        <div class="item" data-lg-img="../img/lb2.jpg" style="background-image: url(/static/img/lb2.jpg);">
        </div>
        <div class="item" data-lg-img="../img/lb3.png" style="background-image: url(/static/img/lb3.png);">
        </div>
        <div class="item" data-lg-img="../img/lb4.jpg" style="background-image: url(/static/img/lb4.jpg);">
        </div>
    </div>

    <!-- 左右控制 -->
    <a class="left carousel-control" href="#lk_carousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#lk_carousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</section>
<!--轮播图-->

<!--内容-->

<!--模块一      简介-->
<div class="introduce">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-offset-2 col-md-4">
                <br /><br />
                <p style="font-size: 24px;">
                    <a href="/topic/${tbContents[0].id}" style="color: #000000;">${tbContents[0].title}</a>
                </p>
                <p style="color: gray;">${tbContents[0].introduction}</p>
            </div>
            <div class="col-sm-offset-1 col-md-4">
                <a href="/topic/${tbContents[0].id}"><img src="${tbContents[0].picture}" width="568px" height="358px" /></a>
            </div>
        </div>
    </div>
</div>
<!--模块一      简介-->

<!--模块二      项目介绍-->
<div class="introduce">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-offset-1 col-md-4">
                <a href="#"><img src="${tbContents[1].picture}" width="568px" height="358px" /></a>
            </div>
            <div class="col-md-offset-3 col-md-3">
                <br /><br />
                <p style="font-size: 24px;">
                    <a href="#" style="color: #000000;">${tbContents[1].title}</a>
                </p>
                <p style="color: gray;">${tbContents[1].introduction}</p>
            </div>

        </div>
    </div>
</div>
<!--模块二      项目介绍-->

<!--模块三      项目更新-->
<div class="introduce">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-offset-2 col-md-4">
                <br /><br />
                <p style="font-size: 24px;">
                    <a href="#" style="color: #000000;">${tbContents[2].title}</a>
                </p>
                <p style="color: gray;">${tbContents[2].introduction}</p>
            </div>
            <div class="col-sm-offset-1 col-md-4">
                <a href="#"><img src="${tbContents[2].picture}" width="568px" height="358px" /></a>
            </div>
        </div>
    </div>
</div>
<!--模块三      项目更新-->

<!--模块四      技术交流-->
<div class="introduce">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-offset-1 col-md-4">
                <a href="#"><img src="${tbContents[3].picture}" width="568px" height="358px" /></a>
            </div>
            <div class="col-md-offset-3 col-md-3">
                <br /><br />
                <p style="font-size: 24px;">
                    <a href="#" style="color: #000000;">${tbContents[3].title}</a>
                </p>
                <p style="color: gray;">${tbContents[3].introduction}</p>
            </div>

        </div>
    </div>
</div>
<!--模块四      技术交流-->
<!--内容-->

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
