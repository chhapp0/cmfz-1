
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/metro-orange/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/echarts.common.min.js"></script>



    <script>

        var $aa,$tt;
        $(function(){
            $aa = $("#menus");
            $tt = $("#tt");


            //初始化系统菜单
            $.post("${pageContext.request.contextPath}/menu/queryAll",function(menus){
                $.each(menus,function(i,menu){

                    var content = "<div style='text-align: center;'>";
                    $.each(menu.menus,function(j,child){
                       // console.log(child);
                       // console.log(JSON.stringify(child));//将js中的js对象转为js中的字符串
                        content +="<div onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\" style='border:1px solid green; width:90%;margin: 5 0 5 0 ;'>"+child.name+"</div>";
                    })
                    content +="</div>";

                    $aa.accordion('add',{
                        title:menu.name,
                        iconCls:menu.iconCls,
                        content:content,
                    });
                });
            },"JSON");
        })



        //添加选项卡
        function  addTabs(title,iconCls,href){
            console.log(title);
            console.log(iconCls);
            console.log(href);
            if(!$tt.tabs('exists',title)){
                $tt.tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    href:"${pageContext.request.contextPath}/"+href,
                    closable:true,
                });
            }else{
                $tt.tabs('select',title)
            }

        }




    </script>
</head>
<body class="easyui-layout">

        <div data-options="region:'north',split:false" style="height:100px;"></div>

        <div data-options="region:'south',split:false" style="height:40px;"></div>

        <div data-options="region:'west',title:'系统菜单',split:false" style="width:200px;">

            <div id="menus" class="easyui-accordion" data-options="fit:true"></div>

        </div>

        <div data-options="region:'center',title:'主页',iconCls:'icon-house'">

            <div id="tt" class="easyui-tabs"></div>

        </div>



</body>
</html>
