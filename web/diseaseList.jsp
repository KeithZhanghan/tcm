<%@ page import="jz.entity.Disease" %><%--
  Created by IntelliJ IDEA.
  Disease: lenovo
  Date: 1419/4/1
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="frame.jsp"></jsp:include>
<html>
<head>
    <title>中医疾病列表</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="14%">中医疾病名称</th>
        <th width="14%">中医疾病描述</th>
        <th width="14%">中医疾病原因</th>
        <th width="14%">中医疾病类型</th>
        <th width="14%">分类依据</th>
        <th width="14%">对应证候</th>
        <th width="16%">操作<button type="button" style="margin-left: 30px" class="btn btn-info" onclick="addD()">添加</button></th>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="disease" items="${diseaseList}">
        <tr>
            <td>${disease.diseaseName}</td>
            <td>${disease.diseaseDescribe}</td>
            <td>${disease.diseaseReason}</td>
            <c:forEach var="type" items="${diseaseTypeList}">
                <c:if test="${disease.diseaseTypeId==type.diseaseTypeId}">
                    <td>${type.diseaseTypeName}</td>
                    <td>${type.diseaseClassify}</td>
                </c:if>
            </c:forEach>
            <c:forEach var="symptom" items="${symptomList}">
                <c:if test="${disease.diseaseSymptomId==symptom.symptomId}">
                    <td>${symptom.symptomName}</td>
                </c:if>
            </c:forEach>
            <td>
                <button type="button" class="btn btn-success" id="edit${disease.diseaseId}" onclick="editD('${disease.diseaseId}')">编辑</button>
                <button type="button" class="btn btn-danger" onclick="deleteD('${disease.diseaseId}')">删除</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">中医疾病信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" action="/addDisease.do" id="diseaseForm">

                    <div class="form-group" id="diseaseDiv" hidden>
                        <label for="diseaseId">中医疾病编号</label><input type="text" class="form-control" id="diseaseId" name="diseaseId" />
                    </div>

                    <div class="form-group">
                        <label for="diseaseName">中医疾病名称</label><input type="text" class="form-control" id="diseaseName" name="diseaseName" />
                    </div>
                    <div class="form-group">
                        <label for="diseaseDescribe">中医疾病描述</label><input type="text" class="form-control" id="diseaseDescribe" name="diseaseDescribe" />
                    </div>
                    <div class="form-group">
                        <label for="diseaseReason">中医疾病原因</label><input type="text" class="form-control" id="diseaseReason" name="diseaseReason" />
                    </div>
                    <div class="form-group">
                        <label for="diseaseTypeId">中医疾病类型</label>
                        <select class="form-control" id="diseaseTypeId" name="diseaseTypeId">
                        <c:forEach items="${diseaseTypeList}" var="diseaseType">
                            <option value="${diseaseType.diseaseTypeId}">${diseaseType.diseaseTypeName}</option>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="diseaseSymptomId">对应证候</label>
                        <select class="form-control" id="diseaseSymptomId" name="diseaseSymptomId">
                            <c:forEach items="${symptomList}" var="symptom">
                                <option value="${symptom.symptomId}">${symptom.symptomName}</option>
                            </c:forEach>
                    </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="document.getElementById('diseaseForm').submit();">提交</button>
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
                <button type="button" class="btn btn-primary" id="deleteDisease">
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

    $('ul a',parent.document).css("color","#777");
    $('.dropdown  a',parent.document).css("color","#777");
    $('.navbar-brand',parent.document).css("color","#777");
    $('.navbar-brand #dsM',parent.document).css("color","blue");
    $('#diseaseM',parent.document).css("color","blue");

    function editD(id) {
        var td=$('#edit'+id).parent().parent().children();
        $('#diseaseId').val(id);
        $("#diseaseDiv").prop("hidden",true);
        $('#diseaseName').val(td.eq(0).html());
        $('#diseaseDescribe').val(td.eq(1).html());
        $('#diseaseReason').val(td.eq(2).html());
       $("#diseaseTypeId option:contains('"+td.eq(3).html()+"')").prop("selected","selected");
       $("#diseaseSymptomId option:contains('"+td.eq(5).html()+"')").prop("selected","selected");
        var url="/editDisease.do";
        $('#diseaseForm').attr("action",url);
        $("#myModal").modal("show");
    }
    function addD() {
        var url="/addDisease.do";
        $('#diseaseForm')[0].reset();
        $("#diseaseDiv").prop("hidden",false);
        $('#diseaseForm').attr("action",url);
        $("#myModal").modal("show");
    };



    function deleteD(account) {
        $("#deleteId").val(account);
        $("#deleteM").modal("show");
    }

    $(
        $("#deleteDisease").click(function () {
            $.ajax(
                {
                    method:"post",
                    url:"/deleteDisease.do",
                    data:{id:$("#deleteId").val()},
                    success:function () {
                        parent.location.href="/diseaseList.do";
                    }
                }
            )
            $("#deleteM").modal("hide");
        })

    )




</script>
</html>
