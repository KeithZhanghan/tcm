<%@ page import="jz.entity.Prescription" %><%--
  Created by IntelliJ IDEA.
  Prescription: lenovo
  Date: 2519/4/1
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="frame.jsp"></jsp:include>
<html>
<head>
    <title>方剂列表</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="25%">方剂名称</th>
        <th width="25%">方剂描述</th>
        <th width="25%">所需药物</th>
        <th width="25%">操作<button type="button" style="margin-left: 30px" class="btn btn-info" onclick="addP()">添加</button></th>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="prescription" items="${prescriptionList}">
        <tr>
            <td>${prescription.prescriptionName}</td>
            <td>${prescription.prescriptionDescribe}</td>

            <c:forEach var="medicine" items="${medicineList}">

                <c:if test="${fn:contains(prescription.prescriptionMedId,medicine.medicineId)}">
            <td> ${medicine.medicineName}        </td>
                    </c:if>

            </c:forEach>

            <td>
                <button type="button" class="btn btn-success" id="edit${prescription.prescriptionId}" onclick="editP('${prescription.prescriptionId}')">编辑</button>
                <button type="button" class="btn btn-danger" onclick="deleteP('${prescription.prescriptionId}')">删除</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">方剂信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" action="/addPrescription.do" id="prescriptionForm">
                    <div class="form-group">
                        <label for="prescriptionId">方剂编号</label><input type="text" class="form-control" id="prescriptionId" name="prescriptionId" />
                    </div>
                    <div class="form-group">
                        <label for="prescriptionName">方剂名称</label><input type="text" class="form-control" id="prescriptionName" name="prescriptionName" />
                    </div>
                    <div class="form-group">
                        <label for="prescriptionDescribe">方剂描述</label><input type="text" class="form-control" id="prescriptionDescribe" name="prescriptionDescribe" />
                    </div>

                    <div class="form-group">
                        <label for="prescriptionMedId">所需药物</label>
                        <select class="form-control" id="prescriptionMedId" name="prescriptionMedId">
                    <c:forEach var="medicine" items="${medicineList}">
                        <option value=" ${medicine.medicineId}">  ${medicine.medicineName}  </option>
                    </c:forEach>
                    </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="document.getElementById('prescriptionForm').submit();">提交</button>
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
                <button type="button" class="btn btn-primary" id="deletePrescription">
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

    function editP(id) {
        var url="/editPrescription.do";
        $('#prescriptionForm').attr("action",url);
        var td=$('#edit'+id).parent().parent().children();
        $('#prescriptionId').val(id);
        $('#prescriptionName').val(td.eq(0).html());
        $('#prescriptionDescribe').val(td.eq(1).html());
        $('#prescriptionMedId option:contains("'+$.trim(td.eq(2).html())+'")').prop("selected","selected");
        $("#myModal").modal("show");
    }
    function addP() {
        var url="/addPrescription.do";
        $('#prescriptionForm').attr("action",url);
        $('#prescriptionForm')[0].reset();
        $("#myModal").modal("show");
    };

    $('ul a',parent.document).css("color","#777");
    $('.dropdown  a',parent.document).css("color","#777");
    $('.navbar-brand',parent.document).css("color","#777");
    $('.navbar-brand #mpM',parent.document).css("color","blue");
    $('#prescriptionM',parent.document).css("color","blue");






    function deleteP(id) {
        $("#deleteId").val(id);
        $("#deleteM").modal("show");
    }
    $(
        $("#deletePrescription").click(function () {
            $.ajax(
                {
                    method:"post",
                    url:"/deletePrescription.do",
                    data:{id:$("#deleteId").val()},
                    success:function () {
                        parent.location.href="/prescriptionList.do";
                    }
                }
            )
            $("#deleteM").modal("hide");
        })

    )




</script>
</html>
