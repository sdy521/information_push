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

            <script type="text/html" id="toolbar">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
                </div>
            </script>

            <script type="text/html" id="rightbar">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>
    <#include "/templates/layout/foot.ftl">
</div>
</body>
<#include "/templates/layout/commonjs.ftl">
<script src="/static/modular/pushConfig/pushConfig.js"></script>
</html>