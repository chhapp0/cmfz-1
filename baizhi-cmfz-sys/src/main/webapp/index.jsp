<%@ page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8"%>


<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/kindeditor-common.js"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/kindeditor.js"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/lang/zh-CN.js"/>
    <script>
        $(function () {
            //富文本编辑器
            KindEditor.ready(function(K) {
                editor = K.create("#editor", {
                    themeType:"simple",//修改主题
                    height: "600px",
                    items: [
                        "source",
                        "preview","fullscreen","clearhtml","|",
                        "undo", "redo","|",
                        "copy", "paste","plainpaste", "wordpaste",
                        "|",
                        "justifycenter", "justifyright",
                        "justifyfull", "insertorderedlist",
                        "insertunorderedlist", "indent", "outdent", "|",
                        "formatblock", "fontname", "fontsize",
                        "forecolor", "hilitecolor", "bold",
                        "italic", "underline", "strikethrough",
                        "lineheight", "removeformat", "|", "image","table", "hr",
                        "emoticons", "baidumap", "pagebreak",
                        "anchor", "link", "unlink"
                    ],
                    langType: 'zh_CN',
                    syncType: "form",
                    filterMode: false,
                    pagebreakHtml: '<hr class="pageBreak" \/>',
                    allowFileManager: true,
                    filePostName: "image",


                    fileManagerJson:"",
                    uploadJson:"",


                    extraFileUploadParams: {
                        token: getCookie("token")
                    },
                    afterChange: function() {
                        this.sync();
                    }
                });
            });
        })
    </script>


</head>
<body>
<h2>Hello World!</h2>
1111
<textarea id="editor" name="" class="editor" style="width: auto;display: none;"></textarea>
</body>
</html>
