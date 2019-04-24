var PushConfig ={
    table:null
}
layui.use('table', function(){
    PushConfig.table = layui.table;
    PushConfig.table.render({
        elem: '#tableId'
        ,url:'/push_config/layuiTable'
        ,toolbar: '#toolbarDemo'
        ,title: '用户数据表'
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
            ,{field:'createTime', title:'创建时间',width:'15%',templet:'<div>{{dateFtt(\'yyyy-MM-dd hh:mm:ss\',new Date(d.createTime))}}</div>'}
            ,{field:'updateTime', title:'修改时间', width:'15%', sort: true,templet:"<div>{{dateFtt(\'yyyy-MM-dd hh:mm:ss\',new Date(d.updateTime))}}</div>"}
            ,{fixed: 'right', title:'操作', toolbar: '#rightTool', width:'20%'}
        ]]
        ,page: true
        ,done:function () {
            interval = setInterval(function () {
                PushConfig.selectRedis();
            },3000);
        }
    });
    //监听行工具事件
    PushConfig.table.on('tool(tableId)', function(obj){
        var data = obj.data;
        if(obj.event === 'send'){
            $("#sendModal").modal();
        }
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
