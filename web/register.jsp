
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/1
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="frame.jsp"></jsp:include>
<html>
<head>
    <title>注册</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                账号注册
            </h3>

            <form role="form" action="/register.do">
                <div class="form-group">
                    <label for="account">账号</label><input type="text" class="form-control" id="account" name="userAccount" />
                </div>
                <div class="form-group">
                    <label for="password">密码</label><input type="password" class="form-control" id="password" name="password" />
                </div>
                <div class="form-group">
                    <label for="repassword">确认密码</label><input type="password" class="form-control" id="repassword" data-container="body" data-toggle="popover" data-placement="right"
                                                               data-content="右侧的 Popover 中的一些内容" />
                    <span id="check" style="display: none">两次密码不一致，请重新输入</span>
                </div>
                <div class="form-group">
                    <label for="username">姓名</label><input type="text" class="form-control" id="username"  name="userName" />
                </div>
                <div class="form-group">
                    <label for="gender">性别</label><select class="form-control" id="gender" name="userGender">
                    <option>男</option>
                    <option>女</option>
                </select>
                </div>
                <div class="form-group">
                    <label for="age">年龄</label><input type="text" class="form-control" id="age" name="userAge" />
                </div>

         <button type="submit" class="btn btn-default">确认提交并登陆</button>
            </form>
        </div>
    </div>
</div>
<div class="footer" align="center">Copyright &nbsp;江西中医药大学 @ Keith </div>
</body>
<style>
    .form-group{
        width: 60%;
        margin: 0 auto;
    }
    .btn{
        margin-left: 500px;
        margin-top: 20px;
    }
</style>

<script>
    $(
        $('#repassword').mouseleave(
        function () {
            if($("#password").val()!=$("#repassword").val()){
                $("#check").css("display","inline");
            }
            else{
                $("#check").css("display","none");
            }

        }
        )
    )
</script>

</html>
