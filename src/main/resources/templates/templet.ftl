<script type="text/html" id="UserName">
<#--laytpl
laytpl 是 JavScript 模板引擎，在字符解析上有着比较出色的表现，欠缺之处在于异常调试上。
由于传统意义的前端模板引擎已经变得不再流行，所以 laytpl 后续可能会进行重写，目前方向暂时还没有想好，
预计会在layui比较稳定后开始实施。-->
{{#
    var view="";
    $.ajax({
        type:"post",
        async:false,
        url:"/common/getUserName?userid="+d.createBy,
        success:function(r){
        if(r.code===0){
            view= r.data.name;
            }
        }
    });
}}
</script>
<script type="text/html" id="Username">
{{#
    var view="";
    $.ajax({
        type:"post",
        async:false,
        url:"/common/getUserName?userid="+d.updateBy,
        success:function(r){
        if(r.code===0){
            view= r.data.name;
            }
        }
    });
}}
</script>
<script type="text/html" id="createTimeTemplet">
{{#
    var createTime = d.createTime;
    var date = new Date(createTime);
    var year = date.getFullYear(),
    month = date.getMonth() + 1,//月份是从0开始的
    day = date.getDate(),
    hour = date.getHours(),
    min = date.getMinutes(),
    sec = date.getSeconds();
    return year+'/'+month+'/'+day;
}}
</script>