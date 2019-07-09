<%@ page import="jz.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/1
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="frame.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="12%">账号</th>
        <th width="12%">姓名</th>
        <th width="12%">密码</th>
        <th width="12%">等级</th>
        <th width="12%">年龄</th>
        <th width="12%">性别</th>
        <th width="20%">操作<button type="button" style="margin-left: 30px" class="btn btn-info" onclick="addU()">添加</button></th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="user" items="${userList}">
    <tr>
        <td>${user.userAccount}</td>
        <td>${user.userName}</td>
        <td>${user.password}</td>
        <c:choose>
            <c:when  test="${user.userRank==1}">
                <td>管理员</td>
            </c:when>
            <c:otherwise>
                <td>普通用户</td>
            </c:otherwise>
        </c:choose>

        <td>${user.userAge}</td>
        <td>${user.userGender}</td>
        <td>
            <button type="button" class="btn btn-success" id="edit${user.userAccount}" onclick="editU('${user.userAccount}')">编辑</button>
            <button type="button" class="btn btn-danger" onclick="deleteU('${user.userAccount}')">删除</button>
        </td>
    </tr>
</c:forEach>

    </tbody>
</table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">用户信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" action="/addUser.do" id="userForm">
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
                        <label for="name">姓名</label><input type="text" class="form-control" id="name" name="userName" />
                    </div>
                    <div class="form-group">
                        <label for="gender">性别</label>
                        <select class="form-control" id="gender" name="userGender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="gender">等级</label>
                        <select class="form-control" id="rank" name="userRank">
                        <option value="1">管理员</option>
                        <option value="2" selected>普通用户</option>
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="age">年龄</label><input type="text" class="form-control" id="age" name="userAge" />
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="document.getElementById('userForm').submit();">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->

</div>

<div class="modal fade" id="deleteM" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h4 class="modal-title" >
                  删除提示
                </h4>
            </div>
            <input type="hidden" id="deleteId" />
            <div class="modal-body">
                确认删除？  按下 ESC 按钮退出。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">退出
                </button>
                <button type="button" class="btn btn-primary" id="deleteUser">
                  确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<style>
table{
    text-align: center;
}
.table thead th {
    vertical-align: middle;
}
</style>
<script>

    function editU(account) {
        var sel=$('#edit'+account).parent().parent().children();
      $('#account').val(sel.eq(0).html());
      $('#password').val(sel.eq(2).html());
        $('#repassword').val(sel.eq(2).html());
        $('#name').val(sel.eq(1).html());
        $('#age').val(sel.eq(4).html());
        $('#gender option[value='+sel.eq(5).html()+']').prop('selected',true);
        $("#rank option:contains('"+sel.eq(3).html()+"')").prop("selected","selected");

        var url="/editUser.do";
        $('#userForm').attr("action",url);
        $("#account").attr("readonly","readonly");


        $("#myModal").modal("show");
    }
    function addU() {
        var url="/addUser.do";
        $('#userForm').attr("action",url);
        $('#userForm')[0].reset();
        $("#myModal").modal("show");
    };

    $('.navbar-brand',parent.document).css("color","#777");
        $('#userM',parent.document).css("color","blue");
        $('ul a',parent.document).css("color","#777");
        $('.dropdown  a',parent.document).css("color","#777");


        function deleteU(account) {
           $("#deleteId").val(account);
           $("#deleteM").modal("show");
        }
        $(
        $("#deleteUser").click(function () {
            $.ajax(
                {
                    method:"post",
                    url:"/deleteUser.do",
                    data:{account:$("#deleteId").val()},
                    success:function () {
                    parent.location.href="/userList.do";
                    }
                }
            )
            $("#deleteM").modal("hide");
        })

        )




</script>
</html>
