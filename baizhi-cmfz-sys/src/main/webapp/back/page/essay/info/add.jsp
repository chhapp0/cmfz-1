<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addEssayForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            标题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            标记: <input name="flag" class="easyui-textbox" data-options="required:true"/><br/>
            上师:<input id="essaycb" name="guru.id" ><br/>
            附属文件:<input name="tex" class="easyui-filebox" data-options="required:true"/><br/>
        </div>
    </form>
</div>


<script>
    $(function () {
        $('#essaycb').combobox({
            url:'/baizhi-cmfz-sys/guru/queryAll',
            valueField:'id',
            textField:'name'
        });
    });


</script>