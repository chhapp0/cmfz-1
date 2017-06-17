<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addUserForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            昵称:<input name="nickname" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            法名:<input name="farmington" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            性别:<input name="gender" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            签名:<input name="description" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            手机:<input name="phone" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
            头像:<input name="pic" class="easyui-filebox" data-options="required:true"/><br/>
            上师:<input id="gurucb" name="guru.id" ><br/>
            省份:<input id="provincecb" class="easyui-combobox" panelHeight="auto" data-options="
                        valueField: 'id',
                        textField: 'name',

                        url: '/baizhi-cmfz-sys/province/showAll',
                        onSelect: function(rec){
                        var url = '/baizhi-cmfz-sys/city/selectByProvince?id='+rec.id;
                        $('#citycb').combobox('reload', url);  }" />
            城市:<input id="citycb" class="easyui-combobox" data-options="valueField:'id',textField:'name'" />

        </div>
    </form>
</div>

<script>
    $(function () {
        $('#gurucb').combobox({
            url:'/baizhi-cmfz-sys/guru/queryAll',
            valueField:'id',
            textField:'name'
        });
    });


</script>