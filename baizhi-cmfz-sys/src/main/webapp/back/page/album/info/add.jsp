<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addAlbumForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名称:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            图片:<input name="pic" class="easyui-filebox" data-options="required:true"/><br/>
            评分:<input name="score" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            作者:<input name="author" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            播音员:<input name="broadcast" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            详情介绍:<input name="brief" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
    </form>
</div>