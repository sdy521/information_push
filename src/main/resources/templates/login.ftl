<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/static/css/layui.css">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">消息推送系统</header>
    <form class="layui-form" action="/j_spring_security_check" method="post">
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="required" placeholder="用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" lay-submit lay-filter="login" class="layui-btn">登录</button>
        </div>
        <hr/>
        <#--<div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-primary">QQ登录</button>
        </div>
        <div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-normal">微信登录</button>
        </div>-->
        <p><a href="/register" class="fr">立即注册</a><#--<a href="javascript:;" class="fl">忘记密码？</a>--></p>
    </form>
</div>
<script src="/static/layui.js"></script>
</body>
</html>