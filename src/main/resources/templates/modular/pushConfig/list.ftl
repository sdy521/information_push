<!DOCTYPE html>
<html>
<head>
    <#include "/templates/layout/meta.ftl">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "/templates/layout/head.ftl">
    <#include "/templates/layout/left.ftl">
    <div class="layui-body">
        <div style="padding: 15px;">
            <!-- 内容主体区域 -->
            <table class="layui-hide" id="tableId" lay-filter="tableId"></table>
        </div>
    </div>
    <#include "/templates/layout/foot.ftl">
</div>
<#--新增弹框-->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="create-form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="url">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">方法</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="method">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm btn-primary" onclick="PushConfig.insert();">确定</button>
                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<#--修改弹框-->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form">
                    <input type="hidden" name="configId">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="url">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">方法</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="method">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm btn-primary" onclick="PushConfig.edit();">确定</button>
                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<#include "/templates/templet.ftl">
<#include "/templates/layout/commonjs.ftl">
<script src="/static/modular/pushConfig/pushConfig.js"></script>
</html>