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
            省份:<select id="provincecb" name="province.id"></select>
            城市:<select id="citycb" name="city.id"></select>

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


        //获取所有省份信息
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"/baizhi-cmfz-sys/province/showAll",
            //dataType:"JSON",
            success:function(result){
                $.each(result,function(i,province){
                    var option = $("<option></option>").text(province.pname).val(province.id);
                    $("#provincecb").append(option);
                });
                //触发省的改变
                $("#provincecb").change();
            }
        });

        //给省份的下拉列表绑定change事件
        $("#provincecb").change(function(){
            //每次发送请求之前清空原有的数据
            $("#citycb").empty();
            //获取当前选中的省份的code
            var provinceCode = $(this).val();
            //根据省份信息查询所有市
            $.ajax({
                type:"POST",
                data:"id="+provinceCode,
                dataType:"json",
                // data:{"provinceCode":provinceCode,"username":"张三"},
                url:"/baizhi-cmfz-sys/city/selectByProvince",
                //dataType:"JSON",
                success:function(result){
                    $.each(result,function(i,city){
                        var option = $("<option></option>").text(city.name).val(city.id);
                        $("#citycb").append(option);
                    });
                    /*
                     //让市触发change事件
                     $("#cc6").change();*/
                }
            });
        });



    });


</script>