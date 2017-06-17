<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editAlbumForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            id:<input name="id" readonly class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            名称:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片:<input name="pic" class="easyui-filebox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            评分:<input name="score" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            作者:<input name="author" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            播音员:<input name="broadcast" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            内容介绍:<input name="brief" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>

    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        console.log("${param.id}");
        $("#editAlbumForm").form('load','/baizhi-cmfz-sys/album/queryOne?id=${param.id}');

    });



</script>