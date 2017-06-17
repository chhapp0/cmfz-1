<%--
  Created by IntelliJ IDEA.
  Work: Lenovo
  Date: 2017/6/11
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var $dg,$da;
        $(function(){
            $dg = $("#workdg");
            $da = $("#workda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/work/showAll',
               // fit:true,
                autoRowHeight:true,
                columns:[[
                    {title:"编号",field:"id",width:250,align:'center'},
                    {title:"功课",field:"category",width:200,align:'center'},
                    {title:"所属用户",field:"uid",width:250,align:'center',
                        formatter:function (value,row,index) {
                            return "<span>"+row.user+"</span>"
                        }
                    },
                    {title:"创建时间",field:"createdate",width:150,align:'center'},

                    {title:"操作",field:"options",width:200,align:'center',
                        formatter:function(value,row,index){
                            return  "<a class='del' onClick=\"del('"+ row.id +"')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                    "<a class='edit' onClick=\"editRow('"+ row.id +"')\"  href='javascript:;'>修改</a>";
                        }
                    }
                ]],
                onLoadSuccess:function(data){
                    $(".del").linkbutton({
                        plain:true,
                        iconCls:'icon-remove',

                    });
                    $(".edit").linkbutton({
                        plain:true,
                        iconCls:'icon-edit',
                    });
                },
                pagination:true,
                pageNumber:1,
                pageSize:10,
                pageList:[2,4,6,8,10],
                toolbar:'#worktb',

            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/work/deleteWork',{"id":id});
                    $dg.datagrid('reload');
                }
            });
        }

        //添加的操作
        function addStu() {
            $da.dialog({
                width:600,
                height:300,
                title:"请填写轮播图的信息",
                iconCls:"icon-man",
                href:'/baizhi-cmfz-sys/back/page/user/work/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveWork,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],

            });

        }

        //修改的操作
        function editRow(id){
            $da.dialog({
                width:600,
                height:300,
                title:"轮播图信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/page/user/work/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upWork,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }]

            });

        }


        //修改
        function upWork(){
            $("#editWorkForm").form('submit',{
                url:'/baizhi-cmfz-sys/work/updateWork',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveWork(){
            $("#addWorkForm").form('submit',{
                url:'/baizhi-cmfz-sys/work/addWork',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //关闭对话框
        function closeDa(){
            $da.dialog('close',true);
        }
    </script>
</head>


<div data-options="region:'center',">
    <table id="workdg" ></table>


    <div id="workda"></div>

    <div id="worktb">
        <a href="javascript:;" onClick="addStu()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>


</html>
