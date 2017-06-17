<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editChapterForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            id:<input name="id" readonly class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            名称:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            文件:<input name="cha" class="easyui-filebox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            文件大小:<input name="csize" readonly="true" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            视频时长:<input name="duration" readonly="true" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            创建时间:<input name="createdate" readonly="true" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        所属专辑:<input id="ccedit" name="album.id" >
    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        console.log("${param.id}");
        $("#editChapterForm").form('load','/baizhi-cmfz-sys/chapter/queryOne?id=${param.id}');


        $('#ccedit').combobox({
            url:'/baizhi-cmfz-sys/album/selectForCha',
            valueField:'id',
            textField:'title',
        });

    });


</script>