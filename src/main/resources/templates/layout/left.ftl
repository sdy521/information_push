<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item <#--layui-nav-itemed-->">
                <a class="" href="javascript:;">推送管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:toastrInfo();">推送配置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="javascript:toastrInfo();">发布信息</a></li>
        </ul>
    </div>
</div>