<%@ page import="jz.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/1
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="frame.jsp"></jsp:include>
<html>
<head>
    <title>中医症状列表</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="20%">中医症状名称</th>
        <th width="20%">可用中药</th>
        <th width="20%">可用方剂</th>
        <th width="20%">可用中医技术</th>
        <th width="20%">操作<button type="button" style="margin-left: 30px" class="btn btn-info" onclick="addS()">添加</button></th>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${symptomList}" var="symptom" >
        <tr>
            <td>${symptom.symptomName}</td>

            <c:forEach var="medicine" items="${medicineList}">
                <c:if test="${symptom.symptomMedId==medicine.medicineId}">
                    <td>${medicine.medicineName}</td>
                </c:if>
            </c:forEach>

            <c:forEach var="prescription" items="${prescriptionList}">
                <c:if test="${symptom.symptomPreId==prescription.prescriptionId}">
                    <td>${prescription.prescriptionName}</td>
                </c:if>
            </c:forEach>
            <c:forEach var="technology" items="${technologyList}">
                <c:if test="${symptom.symptomTecId==technology.technologyId}">
                    <td>${technology.technologyName}</td>
                </c:if>
            </c:forEach>
            <td>
                <button type="button" class="btn btn-success" id="edit${symptom.symptomId}" onclick="editS('${symptom.symptomId}')">编辑</button>
                <button type="button" class="btn btn-danger" onclick="deleteS('${symptom.symptomId}')">删除</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">中医症状信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" action="/addSymptom.do" id="symptomForm">
                    <div class="form-group">
                        <label for="symptomId">中医症状编号</label><input type="text" class="form-control" id="symptomId" name="symptomId" />
                    </div>
                    <div class="form-group">
                        <label for="symptomName">中医症状名称</label><input type="text" class="form-control" id="symptomName" name="symptomName" />
                    </div>

                    <div class="form-group">
                        <label for="symptomMedId">可用中药</label><select class="form-control" id="symptomMedId" name="symptomMedId">
                        <c:forEach var="medicine" items="${medicineList}">
                         <option value="${medicine.medicineId}">${medicine.medicineName}</option>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="symptomPreId">可用方剂</label><select class="form-control" id="symptomPreId" name="symptomPreId">
                        <c:forEach var="prescription" items="${prescriptionList}">
                         <option value="${prescription.prescriptionId}">${prescription.prescriptionName}</option>
                        </c:forEach>
                    </select>
                    </div>

                    <div class="form-group">
                        <label for="symptomTecId">可用技术</label><select class="form-control" id="symptomTecId" name="symptomTecId">
                        <c:forEach var="technology" items="${technologyList}">
                            <option value="${technology.technologyId}">${technology.technologyName}</option>
                        </c:forEach>
                    </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="document.getElementById('symptomForm').submit();">提交</button>
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
                <button type="button" class="btn btn-primary" id="deleteSymptom">
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

    function editS(id) {
        var url="/editSymptom.do";
        $('#symptomForm').attr("action",url);
        $("#symptomId").val(id);
        var td=$('#edit'+id).parent().parent().children();
        console.log(td.eq(0).html())
        $('#symptomName').val(td.eq(0).html());
        $('#symptomMedId option:contains('+td.eq(1).html()+')').prop("selected","selected");
        $('#symptomPreId option:contains('+td.eq(2).html()+')').prop("selected","selected");
        $('#symptomTecId option:contains('+td.eq(3).html()+')').prop("selected",true);
        $("#myModal").modal("show");
    }
    function addS() {
        var url="/addSymptom.do";
        $('#symptomForm').attr("action",url);
        $("#myModal").modal("show");
    };

    $('ul a',parent.document).css("color","#777");
    $('.dropdown  a',parent.document).css("color","#777");
    $('.navbar-brand',parent.document).css("color","#777");
    $('.navbar-brand #dsM',parent.document).css("color","blue");
    $('#symptomM',parent.document).css("color","blue");






    function deleteS(id) {
        $("#deleteId").val(id);
        $("#deleteM").modal("show");
    }
    $(
        $("#deleteSymptom").click(function () {
            $.ajax(
                {
                    method:"post",
                    url:"/deleteSymptom.do",
                    data:{id:$("#deleteId").val()},
                    success:function () {
                        parent.location.href="/symptomList.do";
                    }
                }
            )
            $("#deleteM").modal("hide");
        })

    )




</script>
</html>
