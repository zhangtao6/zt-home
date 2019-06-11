<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/img/smile.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${tbUser.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">功能菜单</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/list"><i class="fa fa-user"></i> 用户列表</a></li>
                    <li><a href="/user/form"><i class="fa fa-user-plus"></i> 新增用户</a></li>
                    <li><a href="/user/auth"><i class="fa fa-user-secret"></i> 用户权限</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-folder-open"></i> <span>模块管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/content/list"><i class="fa fa-map-o"></i>模块列表</a></li>
                    <li><a href="/content/form"><i class="fa fa-edit (alias)"></i>编辑模块</a></li>
                    <li><a href="" onclick="lock()"><i class="fa fa-plus-square-o"></i>增加模块</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-comments-o"></i> <span>评论管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/comment/list"><i class="fa  fa-list-ul"></i>评论列表</a></li>
                    <li><a href="/comment/detail"><i class="fa  fa-list-ul"></i>评论详情</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>

<script>
    function lock() {
        alert("该模块还未开放");
    }
</script>