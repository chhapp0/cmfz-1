<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addWorkForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            功课:<input name="category" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            所属用户:<input id="workcb" name="user.id" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
    </form>
</div>

<script>
    $(function () {
        $('#workcb').combobox({
            url:'/baizhi-cmfz-sys/user/showForWork',
            valueField:'id',
            textField:'nickname'
        });
    });


</script>