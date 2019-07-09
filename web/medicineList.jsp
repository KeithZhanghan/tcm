<%@ page import="jz.entity.Medicine" %><%--
  Created by IntelliJ IDEA.
  Medicine: lenovo
  Date: 2019/4/1
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="frame.jsp"></jsp:include>
<html>
<head>
    <title>中药列表</title>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th width="15%">中药名称</th>
        <th width="15%">中药描述</th>
        <th width="15%">中药功效</th>
        <th width="15%">中药类型</th>
        <th width="15%">分类依据</th>
        <th width="25%">操作<button type="button" style="margin-left: 30px" class="btn btn-info" onclick="addM()">添加</button></th>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${medicineList}" var="medicine" >
        <tr>
            <td>${medicine.medicineName}</td>
            <td>${medicine.medicineDescribe}</td>
            <td>${medicine.medicineEfficacy}</td>
          <c:forEach var="type" items="${medicineTypeList}">
              <c:if test="${medicine.medicineTypeId==type.medicineTypeId}">
                  <td> ${type.medicineTypeName}  </td>
                  <td>${type.medicineClassify}</td>
              </c:if>
          </c:forEach>
            <td>
                <button type="button" class="btn btn-success" id="edit${medicine.medicineId}" onclick="editM('${medicine.medicineId}')">编辑</button>
                <button type="button" class="btn btn-danger" onclick="deleteM('${medicine.medicineId}')">删除</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">中药信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" action="/addMedicine.do" id="medicineForm">
                    <div class="form-group">
                        <label for="medicineId">中药编号</label><input type="text" class="form-control" id="medicineId" name="medicineId" />
                    </div>
                    <div class="form-group">
                        <label for="medicineName">中药名称</label><input type="text" class="form-control" id="medicineName" name="medicineName" />
                    </div>
                    <div class="form-group">
                        <label for="medicineDescribe">中药描述</label><input type="text" class="form-control" id="medicineDescribe" name="medicineDescribe" />
                    </div>
                    <div class="form-group">
                        <label for="medicineEfficacy">中药功效</label><input type="text" class="form-control" id="medicineEfficacy" name="medicineEfficacy" />
                    </div>

                    <div class="form-group">
                        <label for="medicineTypeId">中药类型</label>
                        <select class="form-control" id="medicineTypeId" name="medicineTypeId">
                        <c:forEach var="type" items="${medicineTypeList}">
                            <option value="${type.medicineTypeId}">  ${type.medicineTypeName}  </option>
                        </c:forEach>
                    </select>
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"  onclick="document.getElementById('medicineForm').submit();">提交</button>
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
                <button type="button" class="btn btn-primary" id="deleteMedicine">
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
    $('.navbar-brand #mpM',parent.document).css("color","blue");
    $('#medicineM',parent.document).css("color","blue");


    function editM(id) {
        var td=$('#edit'+id).parent().parent().children();
        $('#medicineId').val(id);
        $('#medicineName').val(td.eq(0).html());
        $('#medicineDescribe').val(td.eq(1).html());
        $('#medicineEfficacy').val(td.eq(2).html());
        $("#medicineTypeId option:contains('"+td.eq(3).html()+"')").prop("selected","selected");

        var url="/editMedicine.do";
        $('#medicineForm').attr("action",url);
        
        $("#myModal").modal("show");
    }
    function addM() {
        var url="/addMedicine.do";
        $('#medicineForm').attr("action",url);
        $('#medicineForm')[0].reset();
        $("#myModal").modal("show");
    };


    



    function deleteM(id) {
        $("#deleteId").val(id);
        $("#deleteM").modal("show");
    }

    $(
        $("#deleteMedicine").click(function () {
            $.ajax(
                {
                    method:"post",
                    url:"/deleteMedicine.do",
                    data:{id:$("#deleteId").val()},
                    success:function () {
                        parent.location.href="/medicineList.do";
                    }
                }
            )
            $("#deleteM").modal("hide");
        })

    )




</script>
</html>
