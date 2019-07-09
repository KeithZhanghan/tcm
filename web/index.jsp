<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/29
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String base=request.getContextPath();
  pageContext.setAttribute("base",base);
%>
<html>
<head>
    <meta charset="utf-8">
    <title>中医药信息管理系统</title>
    <%--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="${base}/bootstrap/min/bootstrap.min.css">
    <script src="${base}/bootstrap/js/jquery.min.js"></script>
    <script src="${base}/bootstrap/js/bootstrap.js"></script>


</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <c:if test="${user.userRank==1}">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/userList.do" id="userM">用户管理</a>
        </div>
        </c:if>

        <div class="navbar-header">
        <div class="navbar-brand">
            <div class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="dsM">
                        中医疾病症状 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/diseaseList.do" id="diseaseM">中医疾病</a></li>
                        <li><a href="/symptomList.do" id="symptomM">中医症状</a></li>

                    </ul>
            </div>
        </div>
        </div>
        <div class="navbar-header">
            <div class="navbar-brand">
                <div class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="mpM"  >
                        中药方剂 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/medicineList.do" id="medicineM">中药</a></li>
                        <li><a href="/prescriptionList.do" id="prescriptionM">方剂</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="/technologyList.do" id="technologyM">中医技术</a>
        </div>
        <div>
            <form class="navbar-form navbar-left" role="search" action="${search}">
                <div class="form-group">
                    <input type="text" name="search" id="search" class="form-control" placeholder="${keyword}">
                </div>
                <button type="submit" class="btn btn-default" >查询</button>
            </form>
        </div>
        <div>
            <a style="display: inline-block ;margin-left: 40px;margin-top: 5px" href="/logout.do">
                <img src="${base}/images/zhuxiao.jpg" width="40px" height="40px">
            </a>
            <span>${user.userName}</span>
        </div>
    </div>
</nav>

<iframe width="100%" height="80%" id="iframeW"   src="${base}/${page}"  frameborder="0" scrolling="auto">

</iframe>

<div class="footer" align="center">Copyright &nbsp;江西中医药大学 @ Keith </div>
</body>
<style>
    .navbar>.container .navbar-brand, .navbar>.container-fluid .navbar-brand {
        margin-left: 60px;
    }
   #search{
        width: 300px;
    }
  ul a{
      font-size: 18px;
  }
    .dropdown-menu>li{
        font-size: 50px;
    }
</style>
</html>