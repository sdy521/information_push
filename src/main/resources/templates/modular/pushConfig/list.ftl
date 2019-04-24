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
        <fieldset class="layui-elem-field" style="margin-top: 15px;">
            <legend>在线人数：<strong>0</strong>人</legend>
        </fieldset>
        <table class="layui-hide" id="tableId" lay-filter="tableId"></table>
        <script type="text/html" id="toolbarDemo"></script>

        <script type="text/html" id="rightTool">
            <a class="layui-btn layui-btn-xs" lay-event="send">推送</a>
        </script>
    </div>
    <#include "/templates/layout/foot.ftl">
<#--推送弹框-->
    <div class="modal fade" id="sendModal" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="modalTitle">推送信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="send-form">
                        <input type="hidden" id="userid">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">选择公告</label>
                            <div class="col-sm-9">
                                <select id="noticeId" class="form-control"></select>
                            </div>
                        </div>
                    </form>
                    <form class="form-group">
                        <textarea id="noticeContent" style="display: none;"></textarea>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-sm btn-primary" onclick="PushConfig.send();">推送</button>
                    <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
<#include "/templates/templet.ftl">
<#include "/templates/layout/commonjs.ftl">
<script src="/static/modular/pushConfig/pushConfig.js"></script>
</html>