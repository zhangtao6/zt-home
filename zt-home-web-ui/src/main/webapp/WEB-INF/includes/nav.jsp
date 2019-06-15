<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--头部-->
<header id="lk_header">
    <nav class="navbar navbar-default navbar-static-top navbar-lk">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <img src="/static/img/tx.jpg" alt="张涛" width="60px	" />
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="lk_nav">
                <ul class="nav navbar-nav">
                    <li class="active" style="margin-right: 5px;">
                        <a href="javascript:;">
                            <font color="#739">主页</font>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <font color="#739">文章</font>
                        </a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right ">
                    <c:if test="${tbUser == null}">
                        <li>
                            <a href="/sign"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;&nbsp;登录</a>
                        </li>
                    </c:if>
                    <c:if test="${tbUser != null}">
                        <li>
                            <a href="/sign">&nbsp;&nbsp;${tbUser.username}</a>
                        </li>
                        <li>
                            <a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;&nbsp;退出</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>
<!--头部-->