<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addBannerForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名称:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            路径:<input name="pic" class="easyui-filebox" data-options="required:true"/><br/>
            状态:<input name="status" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
    </form>
</div>