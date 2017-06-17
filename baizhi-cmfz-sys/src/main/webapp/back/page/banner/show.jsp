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
            $dg = $("#bannerdg");
            $da = $("#bannerda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/banner/showAll',
               // fit:true,
                autoRowHeight:true,
                columns:[[
                    {title:"编号",field:"id",width:220,align:'center'},
                    {title:"名称",field:"name",width:200,align:'center'},
                    {title:"路径",field:"href",width:300,align:'center'},
                    {title:"状态",field:"status",width:50,align:'center'},
                    {title:"操作",field:"options",width:250,align:'center',
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
                toolbar:'#bannertb',

            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/banner/deleteBanner',{"id":id});
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
                href:'/baizhi-cmfz-sys/back/page/banner/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveBanner,
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
                href:'${pageContext.request.contextPath}/back/page/banner/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upBanner,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }]

            });

        }


        //修改
        function upBanner(){
            $("#editBannerForm").form('submit',{
                url:'/baizhi-cmfz-sys/banner/update',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveBanner(){
            $("#addBannerForm").form('submit',{
                url:'/baizhi-cmfz-sys/banner/addBanner',
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
    <table id="bannerdg" ></table>


    <div id="bannerda"></div>

    <div id="bannertb">
        <a href="javascript:;" onClick="addStu()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>


</html>
