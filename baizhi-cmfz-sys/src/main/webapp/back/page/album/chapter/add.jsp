<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addChapterForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名称:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            音频:<input name="cha" class="easyui-filebox" data-options="required:true"/><br/>
            所属专辑:<input id="cc" name="album.id" >
            <br/>
        </div>
    </form>
</div>

<script>
    $(function () {
        $('#cc').combobox({
            url:'/baizhi-cmfz-sys/album/selectForCha',
            valueField:'id',
            textField:'title'
        });

    });


</script>