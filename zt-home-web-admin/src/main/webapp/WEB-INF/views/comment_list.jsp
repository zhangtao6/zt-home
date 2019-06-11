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
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header with-border" style="margin-bottom: 5px">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->

                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="topicType" class="col-sm-2 control-label">模块</label>


                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa  fa-map-o"></i>
                                            </div>
                                            <input  class="form-control pull-right"
                                                    id="topicType" name="topicType" placeholder="模块名">
                                        </div>

                                        <%--<div class="col-sm-10">
                                            <input id="topicType" name="topicType" class="form-control"
                                                   placeholder="模块名">
                                        </div>--%>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-4">
                                    <div class="form-group">
                                        <label for="fromUname" class="col-sm-2 control-label">用户名</label>

                                        <div class="col-sm-10">
                                            <div class="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa  fa-user"></i>
                                                </div>
                                                <input  class="form-control pull-right"
                                                       id="fromUname" name="fromUname" placeholder="用户名">
                                            </div>


                                            <%--<input id="fromUsername" name="fromUsername" class="form-control"
                                                   placeholder="用户名">--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-4">
                                    <div class="form-group">
                                        <label for="reservationtime" class="col-sm-2 control-label">时间段</label>

                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-clock-o"></i>
                                            </div>
                                            <input type="text" class="form-control pull-right"
                                                   id="reservationtime" name="reservationtime">
                                        </div>
                                        <!-- /.input group -->
                                    </div>

                                </div>
                                <div class="row" style="padding-right: 30px;padding-bottom: 10px">
                                    <div class="col-xs-12">
                                        <button class="btn btn-info pull-right" onclick="search()"><i
                                                class="fa fa-search"></i>查询
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/user/form" type="button" class="btn btn-default"  style="display: none"><i class="fa fa-plus"></i>&nbsp;新增</a>&nbsp;
                            <button class="btn btn-default" onclick="App.deleteMulti('delete')"><i
                                    class="fa fa-trash-o"></i>&nbsp;删除
                            </button>&nbsp;
                            <a href="#" type="button" class="btn btn-default" style="display: none"><i
                                    class="fa fa-level-down"></i>&nbsp;导入</a>&nbsp;
                            <a href="#" type="button" class="btn btn-default" style="display: none"><i
                                    class="fa fa-level-up"></i>&nbsp;导出</a>
                            <%--此处jQuery值得学习，显示和隐藏--%>
                            <button class="btn btn-info"
                                    onclick="$('.box-info-search').css('display')== 'none' ? $('.box-info-search').show('fast'):$('.box-info-search').hide('fast')">
                                <i class="fa fa-search"></i>&nbsp;搜索
                            </button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <%--checkbox需要激活才能用--%>
                                    <th><input type="checkbox" class="minimal icheck_master"></th>
                                    <th>用户名</th>
                                    <th>所在模块</th>
                                    <th>评论时间</th>
                                    <th>详细内容</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp"/>

</div>

<jsp:include page="../includes/footer.jsp"/>

//自定义标签用于模态框
<sys:modal/>

<script>
    var _dataTable;
    //表格进行分页
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal">';
                }
            },
            {"data": "fromUname"},
            {"data": "topicType"},
            {
                "data": function (row, type, val, meta) {
                    return DateTime.format(row.updated, "yyyy:MM:dd HH:mm:ss");
                }
            },
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/comment/detail?id=" + row.id;
                    var deleteUrl = "/comment/delete";/*App.showDetail(\'' + detailUrl + '\')*/
                    return '<button type="button" class="btn btn-sm btn-default" onclick="detail(\'' + detailUrl + '\')"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\', \'' + row.id + '\')"><i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];
        _dataTable = App.initDataTables("/comment/page", _columns);

        $('#datepicker').datepicker({
            autoclose: true
        })
        $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' })
    });

    function search() {
        var fromUname = $("#fromUname").val();
        var topicType = $("#topicType").val();
        var updated = $("#reservationtime").val();
        var param = {
            "fromUname": fromUname,
            "topicType": topicType,
            "time": updated

        }
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
    function detail(url) {
        window.location.href=url;
    }
</script>
</body>
</html>
