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
            $dg = $("#essaydg");
            $da = $("#essayda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/essay/showAll',
                //fit:true,
                autoRowHeight:true,
                columns:[[
                    {title:"编号",field:"id",width:200,align:'center'},
                    {title:"名称",field:"title",width:200,align:'center'},
                    {title:"标记",field:"flag",width:200,align:'center'},
                    {title:"发布时间",field:"pubdate",width:200,align:'center'},
                    {title:"上师",field:"flag",width:200,align:'center',
                        formatter:function (value,row,index) {
                            return  "<span>"+row.guru+"</span>"
                        }
                    },
                    {title:"文章路径",field:"link",width:200,align:'center'},
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
                toolbar:'#essaytb',

            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/essay/deleteEssay',{"id":id});
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
                href:'/baizhi-cmfz-sys/back/page/essay/info/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveEssay,
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
                href:'${pageContext.request.contextPath}/back/page/essay/info/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upEssay,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }]

            });

        }


        //修改
        function upEssay(){
            $("#editEssayForm").form('submit',{
                url:'/baizhi-cmfz-sys/essay/update',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveEssay(){
            $("#addEssayForm").form('submit',{
                url:'/baizhi-cmfz-sys/essay/addEssay',
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
    <table id="essaydg" ></table>

    <div id="essayda"></div>

    <div id="essaytb">
        <a href="javascript:;" onClick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>


</html>
