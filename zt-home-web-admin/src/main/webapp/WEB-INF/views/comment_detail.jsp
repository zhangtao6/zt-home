<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>ZT-Home | 控制面板</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/dropzone.css"/>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css"/>
    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css">
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
            <div class="row">
                <div class="col-md-12">
                    <%--模态框--%>
                    <c:if test="${baseResult.message != null}">
                        <div class="alert alert-${baseResult.status == 200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">编辑模块</h3>
                        </div>
                        <!-- /.box-header -->

                        <form:form  id="inputForm" cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbComment">
                            <%--此处获取到了此tbContent的id但是我们不需要显示出来，但是需要提交，所以可以将它隐藏掉--%>
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="fromUname" class="col-sm-offset-2 col-sm-2 control-label">评论者</label>

                                    <div class="col-sm-4">
                                        <form:input readonly="true" cssClass="form-control required" path="fromUname"  placeholder="评论者"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="topicType" class="col-sm-offset-2 col-sm-2 control-label">所在模块</label>

                                    <div class="col-sm-4">
                                        <form:input readonly="true"  cssClass="form-control" path="topicType" placeholder="所在模块"/>
                                            <%--<input type="password" id="password" name="password" class="form-control required"placeholder="请输入密码"/>--%>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="updated" class="col-sm-offset-2 col-sm-2 control-label">评论时间</label>

                                    <div class="col-sm-4">
                                        <form:input readonly="true" cssClass="form-control required" path="updated" placeholder="评论时间"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">内容</label>

                                    <div class="col-sm-8">
                                        <form:hidden path="content"/>
                                            <%--富文本编辑器--%>
                                        <div id="editor" aria-readonly="true">
                                                <%--尝试猜测：这里面所有的内容应该都是有标签的--%>
                                                ${tbComment.content}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer text-center">
                                    <%--此处值得学习，onclick返回上一个页面--%>
                                <button type="button" class="btn btn-default" onclick="history.go(-1);" style="margin-right: 50px">返回</button>
                                <button type="submit" class="btn btn-info " style="margin-left: 50px;" onclick="javascript:this.disabled=true">修改</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>

                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp"/>

</div>

<jsp:include page="../includes/footer.jsp"/>

<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>


<script>

    $(function () {
        initWangEditor();
    });
    //富文本编辑器
    function initWangEditor() {
        var E = window.wangEditor;
        var editor = new E("#editor");
        //配置上传文件到服务器
        editor.customConfig.uploadImgServer = "/upload";
        editor.customConfig.uploadFileName = "editorFile";
        editor.create();

        //$("#btn-submit").disabled(true);
    }
</script>
</body>
</html>