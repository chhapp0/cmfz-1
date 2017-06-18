<%--
  Created by IntelliJ IDEA.
  User: Lenovo
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
            $dg = $("#gurudg");
            $da = $("#guruda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/guru/showAll',
                //fit:true,
                autoRowHeight:true,
                columns:[[
                    {title:"编号",field:"id",width:200,align:'center'},
                    {title:"姓名",field:"name",width:200,align:'center'},
                    {title:"头像",field:"head",width:200,align:'center'},

                    {title:"操作",field:"options",width:300,align:'center',
                        formatter:function(value,row,index){
                            return  "<a class='del' onClick=\"del('"+ row.id +"')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                    "<a class='edit' onClick=\"editRow('"+ row.id +"')\"  href='javascript:;'>修改</a>";
                        }
                    },

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
                toolbar:'#gurutb',

            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/guru/deleteGuru',{"id":id});
                    $dg.datagrid('reload');
                }
            });
        }

        //添加的操作
        function add() {
            $da.dialog({
                width:600,
                height:300,
                title:"请填写上师信息",
                iconCls:"icon-man",
                href:'/baizhi-cmfz-sys/back/page/essay/guru/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveGuru,
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
                width:1000,
                height:500,
                title:"上师信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/page/essay/guru/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upGuru,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }]

            });

        }


        //修改
        function upGuru(){
            $("#editGuruForm").form('submit',{
                url:'/baizhi-cmfz-sys/guru/updateGuru',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveGuru(){
            $("#addGuruForm").form('submit',{
                url:'/baizhi-cmfz-sys/guru/addGuru',
                /*ajax方式提交   防止chrome不识别*/
                contentType: false,
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
    <table id="gurudg" ></table>

    <div id="guruda"></div>

    <div id="gurutb">
        <a href="javascript:;" onClick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>


</html>
