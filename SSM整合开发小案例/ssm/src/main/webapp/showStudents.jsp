
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览学生</title>
    <!-- 引入jQuery文件-->
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            // 在页面加载后，执行Ajax，获取数据
            getStudentInfo();
            $("#doAjax").click(function () {
                getStudentInfo();
            })
        })
        function getStudentInfo() {
            $.ajax({
                url:"student/queryStudent.do",
                dataType:"json",
                success:function (rsp) {
                    //alert(resp)
                    $("#stuInfo").empty();
                    $.each(rsp, function (i,n) {
                        $("#stuInfo").append("<tr><td>"
                            +n.id+"</td><td>"
                            +n.name+"</td><td>"
                            +n.age+"</td></tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <p>浏览学生<button id="doAjax">获取学生数据</button></p>
        <table>
            <!--thead表示表头 -->
            <thead>
                <tr>
                    <td>id</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="stuInfo">

            </tbody>
        </table>
    </div>

</body>
</html>
