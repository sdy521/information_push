var PushConfig ={
    table:null
}
layui.use('table', function(){
    PushConfig.table = layui.table;
        PushConfig.table.render({
        elem: '#tableId'
        ,url:'/push_config/layuiTable'
        ,toolbar: 'default'
        ,title: '用户数据表'
        // ,totalRow: true //开启合计行
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'ID', width:'10%', fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'姓名', width:'20%'/*, edit: 'text'*/}
            ,{field:'type', title:'职位', width:'15%',templet:function (res) {
                        var type = res.type;
                        if(type==0){
                            return "管理员";
                        }else if(type==1){
                            return "老师";
                        }else if(type==2){
                            return "学生";
                        }
                    }}
           /* ,{field:'createBy', title:'创建人', width:'10%',templet:"#UserName"}
            ,{field:'updateBy', title:'修改人', width:'10%',templet:"#Username"}*/
            ,{field:'createTime', title:'创建时间',width:'15%',templet:'<div>{{dateFtt(yyyy-MM-dd,d.createTime)}}</div>'}
            ,{field:'updateTime', title:'修改时间', width:'15%', sort: true,templet:"<div>{{dateFtt('yyyy-MM-dd',d.updateTime)}}</div>"}
        ]]
        ,page: true
        ,done:function () {
            interval = setInterval(function () {
                PushConfig.selectRedis();
            },3000);
        }
    });
    //监听头工具栏事件
    PushConfig.table.on('toolbar(tableId)', function(obj){
        var checkStatus = PushConfig.table.checkStatus(obj.config.id),data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                $("#createModal").modal();
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    var id = checkStatus.data[0].id;
                    $.ajax({
                        url:"/push_config/editModal?id="+id,
                        type:"GET",
                        dataType:"JSON",
                        success:function (r) {
                            if(r.code===0){
                                var data = r.data;
                                $("#update-form").find("input[name='configId']").val(data.id);
                                $("#update-form").find("input[name='url']").val(data.url);
                                $("#update-form").find("input[name='method']").val(data.method);
                                $("#updateModal").modal();
                            }else {
                                layer.msg("出现错误");
                            }
                        }
                    });
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    //询问框
                    layer.confirm('确定删除吗？', {
                        btn: ['确定','取消'] //按钮
                    }, function(){
                        var idArray = new Array();
                        var datas = checkStatus.data;
                        for(var i=0;i<datas.length;i++){
                            idArray.push(parseInt(datas[i].id));
                        }
                        $.ajax({
                            url:"/push_config/delete",
                            type:"POST",
                            data:{ids:idArray},
                            dataType:"JSON",
                            traditional: true,//解决传递数组的问题
                            success:function (r) {
                                if(r.code===0){
                                    PushConfig.reloadTable();
                                    layer.msg("删除成功");
                                }
                            }
                        });
                    }, function(){
                        layer.msg('取消成功', {icon: 1});
                    });
                }
                break;
        };
    });
});
//执行重载
PushConfig.reloadTable = function(){
    PushConfig.table.reload('tableId', {
        page: {
            curr: 1 //重新从第 1 页开始
        }
        , where: {//这里传参  向后台
            // name: name
            //可传多个参数到后台...  ，分隔
        }
        , url: '/push_config/layuiTable'//后台做模糊搜索接口路径
        , method: 'post'
    });
}
//编辑确定
PushConfig.edit = function () {
    var id = $("#update-form").find("input[name='configId']").val();
    var url = $("#update-form").find("input[name='url']").val();
    var method = $("#update-form").find("input[name='method']").val();
    $.ajax({
        url:"/push_config/edit?id="+id+"&url="+url+"&method="+method,
        type:"GET",
        dataType:"JSON",
        success:function (r) {
            if(r.code===0){
                $("#updateModal").modal('hide');
                PushConfig.reloadTable();
                layer.msg("修改成功");
            }
        }
    });
}
//查询redis
PushConfig.selectRedis = function(){
    $.ajax({
        url:"/push_config/getRedis",
        type:"GET",
        dataType:"JSON",
        success:function (r) {
            if(r.code===0){
                $(".layui-elem-field").find("legend").find("strong").html(r.data);
            }
        }
    });
}
//添加确定
PushConfig.insert = function () {
    var url = $("#create-form").find("input[name='url']").val();
    var method = $("#create-form").find("input[name='method']").val();
    $.ajax({
        url:"/push_config/insert?url="+url+"&method="+method,
        type:"GET",
        dataType:"JSON",
        success:function (r) {
            if(r.code===0){
                $("#createModal").modal('hide');
                PushConfig.reloadTable();
                layer.msg("添加成功");
            }
        }
    });
}
