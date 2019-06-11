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
                内容管理
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
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="#" type="button" class="btn btn-default"><i class="fa fa-plus"></i>&nbsp;新增</a>&nbsp;
                            <button class="btn btn-default" onclick="App.deleteMulti('delete')"><i
                                    class="fa fa-trash-o"></i>&nbsp;删除
                            </button>&nbsp;
                            <a href="#" type="button" class="btn btn-default" style="display: none"><i
                                    class="fa fa-level-down"></i>&nbsp;导入</a>&nbsp;
                            <a href="#" type="button" class="btn btn-default" style="display: none"><i
                                    class="fa fa-level-up"></i>&nbsp;导出</a>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover" style='table-layout:fixed;'>
                                <thead>
                                <tr>
                                    <th class="col-sm-1">ID</th>
                                    <th class="col-sm-2">标题</th>
                                    <th class="col-sm-3">简介</th>
                                    <th class="col-sm-1">图片</th>
                                    <th class="col-sm-3">描述</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${baseResult.data}" var="tbContent">
                                    <tr>
                                        <td>${tbContent.id}</td>
                                        <td>${tbContent.title}</td>
                                        <td>${tbContent.introduction}</td>
                                        <td><a href="${tbContent.picture}">查看</a></td>
                                        <td style="overflow: hidden;white-space: nowrap;text-overflow:ellipsis;"><a>见详情</a></td>
                                        <td><a href="/content/form?id=${tbContent.id}" type="button"
                                               class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a></td>
                                    </tr>
                                </c:forEach>
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

<%--//自定义标签用于模态框--%>
<sys:modal/>
</body>
</html>