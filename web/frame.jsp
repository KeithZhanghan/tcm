<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/29
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String base=request.getContextPath();
pageContext.setAttribute("base",base);
%>
<html>
<head>
</head>

<body>

</body>
<link rel="stylesheet" href="${pageScope.base}/bootstrap/css/bootstrap.css" />
<script src="${base}/bootstrap/js/jquery.js"></script>
<script src="${base}/bootstrap/js/bootstrap.js"></script>
</html>
