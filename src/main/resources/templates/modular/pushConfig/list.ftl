<!DOCTYPE html>
<html>
<head>
    <#include "/templates/layout/meta.ftl">
    <style>
        input[type="radio"] {
            width: 20px;
            height: 20px;
            opacity: 0;
        }
        .radio-inline label {
            position: absolute;
            left: 5px;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            border: 1px solid #999;
        }
        /*设置选中的input的样式*/
        /* + 是兄弟选择器,获取选中后的label元素*/
        input:checked+label {
            background-color: #fe6d32;
            border: 1px solid #fe6d32;
        }

        input:checked+label::after {
            position: absolute;
            content: "";
            width: 5px;
            height: 10px;
            top: 3px;
            left: 6px;
            border: 2px solid #fff;
            border-top: none;
            border-left: none;
            transform: rotate(45deg)
        }
    </style>
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
                    <form class="form-group">
                        <div class="radio-inline">
                            <input id="item1" type="radio" name="item" value="2">
                            <label for="item1"></label>&nbsp;&nbsp;
                            <span>紧急</span>
                        </div>
                        <div class="radio-inline">
                            <input id="item2" type="radio" name="item" value="1">
                            <label for="item2"></label>&nbsp;&nbsp;
                            <span>重要</span>
                        </div>
                        <div class="radio-inline">
                            <input id="item3" type="radio" name="item" value="0" checked>
                            <label for="item3"></label>&nbsp;&nbsp;
                            <span>一般</span>
                        </div>
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