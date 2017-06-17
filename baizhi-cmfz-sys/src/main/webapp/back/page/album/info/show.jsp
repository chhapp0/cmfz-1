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
            $dg = $("#albumdg");
            $da = $("#albumda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/album/showAll',
                //fit:true,
                autoRowHeight:true,
                columns:[[
                    {title:"编号",field:"id",width:200,align:'center'},
                    {title:"图片路径",field:"thumbnail",width:200,align:'center'},
                    {title:"标题",field:"title",width:200,align:'center'},
                    {title:"评分",field:"score",width:200,align:'center'},
                    {title:"作者",field:"author",width:200,align:'center'},
                    {title:"播音员",field:"broadcast",width:200,align:'center'},
                    {title:"发布日期",field:"createdate",width:200,align:'center'},
                    {title:"内容介绍",field:"brief",width:200,align:'center'},
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
                toolbar:'#albumtb',

            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/album/deleteAlbum',{"id":id});
                    $dg.datagrid('reload');
                }
            });
        }

        //添加的操作
        function add() {
            $da.dialog({
                width:600,
                height:300,
                title:"请填写轮播图的信息",
                iconCls:"icon-man",
                href:'/baizhi-cmfz-sys/back/page/album/info/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveAlbum,
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
                title:"轮播图信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/page/album/info/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upAlbum,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }]

            });

        }


        //修改
        function upAlbum(){
            $("#editAlbumForm").form('submit',{
                url:'/baizhi-cmfz-sys/album/update',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveAlbum(){
            $("#addAlbumForm").form('submit',{
                url:'/baizhi-cmfz-sys/album/addAlbum',
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
    <table id="albumdg" ></table>

    <div id="albumda"></div>

    <div id="albumtb">
        <a href="javascript:;" onClick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>


</html>
