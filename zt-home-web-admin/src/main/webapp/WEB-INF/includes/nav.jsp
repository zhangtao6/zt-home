<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>ZT-</b>Home</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>ZT-</b>Home</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">${tbUser.username}</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <%--<img src="/static/assets/img/user2-160x160.jpg" class="user-image" alt="User Image">--%>
                        <img src="/img/smile.png" class="img-circle" alt="User Image" width="40" height="40">
                        <span class="hidden-xs">${tbUser.username}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <%--<img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                            <img src="/img/smile.png" class="img-circle" alt="User Image">

                            <p>
                                ${tbUser.username} - Java Developer
                                <small>
                                    <fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </small>
                            </p>
                        </li>

                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">个人信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>