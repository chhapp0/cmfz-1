<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editGuruForm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}" />
        姓名:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        图片: <input name="pic" class="easyui-filebox" data-options="required:true"/><br/>

    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        console.log("${param.id}");
        $("#editGuruForm").form('load','/baizhi-cmfz-sys/guru/queryOne?id=${param.id}');

    });



</script>