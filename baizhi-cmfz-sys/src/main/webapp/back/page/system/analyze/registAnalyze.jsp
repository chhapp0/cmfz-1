<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    $(function () {
    //创建柱状图

    //DOM------> Jquery  $(DOM)
    //jquery------->DOM  jquery对象[0]
    var myChart = echarts.init($("#registCount")[0]);
    $.post("${pageContext.request.contextPath}/user/registCount",function(data){
        var dd = eval(data);
        console.log(dd)
        //配置echars
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '统计用户注册数'
            },
            tooltip: {},
            legend: {
                data:['用户数量']
            },
            xAxis: {
                data: dd.dates
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: dd.counts
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

    },"JSON");



    });
</script>

<div id="registCount" style="width: 600px;height:400px;"></div>