<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editWorkForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            <input type="hidden" value="${param.id}" name="id">
            功课:<input name="category" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            创建时间:<input name="createdate" readonly="readonly" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        $("#editWorkForm").form('load','/baizhi-cmfz-sys/work/selectOne?id=${param.id}');

    });



</script>