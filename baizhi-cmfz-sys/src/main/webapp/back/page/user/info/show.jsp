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
            $dg = $("#userdg");
            $da = $("#userda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/user/showAll',
               // fit:true,
                autoRowHeight:true,
                columns:[[
                    {title:"编号",field:"id",width:220,align:'center'},
                    {title:"昵称",field:"nickname",width:200,align:'center'},
                    {title:"法名",field:"farmington",width:200,align:'center'},
                    {title:"性别",field:"gender",width:50,align:'center'},
                    {title:"签名",field:"description",width:250,align:'center'},
                    {title:"手机",field:"phone",width:100,align:'center'},
                    {title:"头像",field:"photo",width:50,align:'center'},
                    {title:"上师",field:"guruName",width:100,align:'center',
                        formatter:function (value,row,index) {
                            return  "<span>"+row.guru.name+"</span>"
                        }
                    },
                   {title:"省份",field:"provinceName",width:100,align:'center',
                        formatter:function (value,row,index) {
                            return  "<span>"+row.province.pname+"</span>"
                        }
                    },
                    {title:"城市",field:"cityName",width:100,align:'center',
                        formatter:function (value,row,index) {
                            return  "<span>"+row.city.name+"</span>"
                        }
                    },
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
                toolbar:'#usertb',

            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/user/deleteUser',{"id":id});
                    $dg.datagrid('reload');
                }
            });
        }

        //添加的操作
        function addStu() {
            $da.dialog({
                width:600,
                height:300,
                title:"用户信息",
                iconCls:"icon-man",
                href:'/baizhi-cmfz-sys/back/page/user/info/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveUser,
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
                title:"用户信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/page/user/info/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upUser,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }]

            });

        }


        //修改
        function upUser(){
            $("#editUserForm").form('submit',{
                url:'/baizhi-cmfz-sys/user/updateUser',
                contentType:false,
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveUser(){
            $("#addUserForm").form('submit',{
                url:'/baizhi-cmfz-sys/user/addUser',
                contentType:false,
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
    <table id="userdg" ></table>


    <div id="userda"></div>

    <div id="usertb">
        <a href="javascript:;" onClick="addStu()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>


</html>
