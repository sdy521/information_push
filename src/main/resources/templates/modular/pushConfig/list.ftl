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
</body>
<#include "/templates/layout/commonjs.ftl">
<script src="/static/modular/pushConfig/pushConfig.js"></script>
</html>