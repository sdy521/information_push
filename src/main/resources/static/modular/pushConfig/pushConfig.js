
layui.use('table', function(){
    var table = layui.table;
        table.render({
        elem: '#tableId'
        ,url:'/push_config/layuiTable'
        ,toolbar: 'default'
        ,title: '用户数据表'
        // ,totalRow: true //开启合计行
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'ID', width:'10%', fixed: 'left', unresize: true, sort: true}
            ,{field:'url', title:'地址', width:'20%'/*, edit: 'text'*/}
            ,{field:'method', title:'方法', width:'15%'/*, edit: 'text'*/}
            ,{field:'createBy', title:'创建人', width:'10%'}
            ,{field:'updateBy', title:'修改人', width:'10%'}
            ,{field:'createTime', title:'创建时间',width:'15%',}
            ,{field:'updateTime', title:'修改时间', width:'15%', sort: true}
           /* ,{field:'deleted', title:'是否删除', width:'10%',templet:function (res) {
                        var del = res.deleted;
                        if(del===false){
                            return '未删除';
                        }else{
                            return '已删除';
                        }
                    }}*/
        ]]
        ,page: true
    });
    //监听头工具栏事件
    table.on('toolbar(tableId)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id),data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });
});
