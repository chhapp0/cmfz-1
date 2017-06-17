<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editEssayForm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}" />
        标题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        标记: <input name="flag" class="easyui-textbox" data-options="required:true"/><br/>
        发布时间:<input name="pubdate" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        上师:<input id="essaycb1" name="guru.id" ><br/>
        附属文件:<input name="tex" class="easyui-filebox" data-options="required:true"/><br/>

    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        console.log("${param.id}");
        $("#editEssayForm").form('load','/baizhi-cmfz-sys/essay/queryOne?id=${param.id}');

        $('#essaycb1').combobox({
            url:'/baizhi-cmfz-sys/guru/queryAll',
            valueField:'id',
            textField:'name'
        });
    });



</script>