<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>
    <title>ZT-Home | 控制面板</title>
    <jsp:include page="../includes/header.jsp"/>

<body class="hold-transition skin-blue sidebar-mini">


<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>

    <jsp:include page="../includes/menu.jsp"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <%--模态框--%>
                    <c:if test="${baseResult.message != null}">
                        <div class="alert alert-${baseResult.status == 200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border" style="margin-bottom: 5px">
                            <h3 class="box-title">搜索</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="username" class="col-sm-2 control-label">姓名</label>

                                        <div class="col-sm-10">
                                            <input id="username" name="username" class="form-control" placeholder="name">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">邮箱</label>

                                        <div class="col-sm-10">
                                            <input id="email" name="email" class="form-control" placeholder="email">
                                        </div>
                                    </div>
                                </div>

                                <div class="row" style="padding-right: 30px;padding-bottom: 10px">
                                    <div class="col-xs-12">
                                        <button  class="btn btn-info pull-right" onclick="search()"><i class="fa fa-search"></i>查询
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户权限</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>权限</th>
                                </tr>
                                </thead>
                                <tbody>
                                 <tr id="userData">

                                 </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-body text-center" id="endContent" style="color: red">

                        </div>
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp"/>
</div>
<button style="margin-top: 10px" id="" onclick="exchange()">设为普通用户</button>
<jsp:include page="../includes/footer.jsp"/>

//自定义标签用于模态框
<sys:modal/>

<script>
    /**
     * 用于对于用户权限修改的单一搜索
     */
    function search() {
        var username = $("#username").val();
        var email = $("#email").val();
        $.ajax({
            url: "searchAuth",
            type: "GET",
            data: {"username":username,"email":email},
            success:function (data) {
                $("#userData").empty();
                $("#endContent").html("");
                if (data.id != null) {
                    $("#userData").append("<td id=\"selectId\">" + data.id + "</td>");
                    $("#userData").append("<td>" + data.username + "</td>");
                    $("#userData").append("<td>" + data.email + "</td>");
                    if(data.authority==1){
                        $("#userData").append("<td>超级用户</td>");
                            $("#userData").append("<button style=\"margin-top: 5px\" name=\"" +data.id + "\" onclick=\"exchange()\" >设为普通用户</button>");
                    }
                    else{
                        $("#userData").append("<td>普通用户</td>");
                        $("#userData").append("<button style=\"margin-top: 5px\" name=\"" +data.id + "\" onclick=\"exchange()\" >设为超级用户</button>");
                    }
                }else {
                    $("#endContent").html("没有此用户");
                }
            }
        })
    }

    /**
     * 权限修改操作
     * 异步ajax
     */
    function exchange() {
        $.ajax({
            url: 'exchange',
            type: 'GET',
            data: 'id=' + $("#selectId").text(),
            success:function (data) {
                $("#modal-default").modal("show");
                $("#modal-message").html(data.message);
                $("#btnModalOk").bind("click", function () {
                    $("#modal-default").modal("hide");
                    window.location.reload();
                });

            }
        })
    }
</script>
</body>
</html>