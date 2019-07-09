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
<html>
<head>
    <title>中医技术列表</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="20%">中医技术名称</th>
        <th width="20%">中医技术描述</th>
        <th width="20%">中医技术类型</th>
        <th width="20%">分类依据</th>
        <th width="20%">操作<button type="button" style="margin-left: 30px" class="btn btn-info" onclick="addT()">添加</button></th>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="technology" items="${technologyList}">
        <tr>
            <td>${technology.technologyName}</td>
            <td>${technology.technologyDescribe}</td>
            <c:forEach var="type" items="${technologyTypeList}">
                <c:if test="${technology.technologyTypeId==type.technologyTypeId}">
                    <td>${type.technologyTypeName}</td>
                    <td>${type.technologyClassify}</td>
                </c:if>
            </c:forEach>
            <td>
                <button type="button" class="btn btn-success" id="edit${technology.technologyId}" onclick="editT('${technology.technologyId}')">编辑</button>
                <button type="button" class="btn btn-danger" onclick="deleteT('${technology.technologyId}')">删除</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">中医技术信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" action="/addTechnology.do" id="technologyForm">
                    <div class="form-group">
                        <label for="technologyId">中医技术编号</label><input type="text" class="form-control" id="technologyId" name="technologyId" />
                    </div>
                    <div class="form-group">
                        <label for="technologyName">中医技术名称</label><input type="text" class="form-control" id="technologyName" name="technologyName" />
                    </div>
                    <div class="form-group">
                        <label for="technologyDescribe">中医技术描述</label><input type="text" class="form-control" id="technologyDescribe" name="technologyDescribe" />
                    </div>

                    <div class="form-group">
                        <label for="technologyTypeId">中医技术类型</label><select class="form-control" id="technologyTypeId" name="technologyTypeId">
                        <c:forEach var="type" items="${technologyTypeList}">
                            <option value="${type.technologyTypeId}">
                                    ${type.technologyTypeName}
                            </option>
                        </c:forEach>
                    </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="document.getElementById('technologyForm').submit();">提交</button>
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
                <button type="button" class="btn btn-primary" id="deleteTechnology">
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

    function editT(id) {
        var url="/editTechnology.do";
        $('#technologyForm').attr("action",url);
        var td=$('#edit'+id).parent().parent().children();
        $("#technologyId").val(id);
        $('#technologyName').val(td.eq(0).html());
        $('#technologyDescribe').val(td.eq(1).html());
        $("#technologyTypeId option:contains("+td.eq(2).html()+")").prop('selected',true);
        $("#myModal").modal("show");
    }
    function addT() {
        var url="/addTechnology.do";
        $('#technologyForm')[0].reset();
        $('#technologyForm').attr("action",url);
        $("#myModal").modal("show");
    };

    $('.navbar-brand',parent.document).css("color","#777");
    $('#technologyM',parent.document).css("color","blue");
    $('ul a',parent.document).css("color","#777");
    $('.dropdown  a',parent.document).css("color","#777");






    function deleteT(account) {
        $("#deleteId").val(account);
        $("#deleteM").modal("show");
    }
    $(
        $("#deleteTechnology").click(function () {
            $.ajax(
                {
                    method:"post",
                    url:"/deleteTechnology.do",
                    data:{id:$("#deleteId").val()},
                    success:function () {
                        parent.location.href="/technologyList.do";
                    }
                }
            )
            $("#deleteM").modal("hide");
        })

    )




</script>
</html>
