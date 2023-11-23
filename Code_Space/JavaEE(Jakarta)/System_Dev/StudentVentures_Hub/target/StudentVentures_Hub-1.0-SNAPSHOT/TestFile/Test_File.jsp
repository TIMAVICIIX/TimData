<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>异步加载数据</title>
    <script src="../static/Jquery/jquery-3.7.1.js"></script>
</head>
<body>

num1:<input type="number" name="num1" id="num1"><br>
num2:<input type="number" name="num2" id="num2"><br>

<button onclick="submitData()">Submit</button>
<br>

<h3></h3>

<script>
    function submitData() {
        const num_1 = $('#num1').val();
        const num_2 = $('#num2').val();

        $.ajax({
            url: "<%=request.getContextPath()%>/get_test",
            type: "POST",
            data:{num1:num_1,num2:num_2},
            dataType: "text",
            success:function (data,testStatus){
                $('h3').text(data);
            }
        });
    }
</script>

</body>
</html>
