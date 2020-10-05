<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2020/10/5
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="/static/js/jquery-1.12.4.js"></script>
<body>
<form action="/" method="post">
    <input type="hidden" name="pageNum" value="1">
    <p align="center">申报状态：
    <select name="status">
            <option value="0">已申报</option>
            <option value="1">审核中</option>
            <option value="2">已审核</option>
    </select>
    <input type="submit" value="查询">
    </p>
</form>
<table border="1px" align="center" width="500px">
    <tr>
        <td colspan="8" align="center"><h2>申报项目列表</h2></td>
    </tr>
    <tr id="a">
        <td>项目编号</td>
        <td>项目名称</td>
        <td>申报开始日期</td>
        <td>申报结束日期</td>
        <td>申报状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${projectinfos}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.projectname}</td>
            <td>${pro.startdate}</td>
            <td>${pro.enddate}</td>
            <td>
                <c:if test=" ${pro.status==0}">已申报</c:if>
                <c:if test=" ${pro.status==1}">审核中</c:if>
                <c:if test=" ${pro.status==2}">已审核</c:if>
            </td>
            <td><a href="/toupd?id=${pro.id}">审核</a></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${pageInfo.isFirstPage==false}">
    <a href="/?pageNum=${pageInfo.firstPage}&status=${status}">首页</a>
    <a href="/?pageNum=${pageInfo.prePage}&status=${status}">上一页</a>
</c:if>
<c:if test="${pageInfo.isLastPage==false}">
    <a href="/?pageNum=${pageInfo.nextPage}&status=${status}">下一页</a>
    <a href="/?pageNum=${pageInfo.lastPage}&status=${status}">尾页</a>
</c:if>
第${pageInfo.pageNum}页/共${pageInfo.pages}页
</body>
</html>
<script type="text/javascript">
    $("tr:even").css("background-color","pink");
    $("#a").css("background-color","rgb(128,128,128)")
</script>
