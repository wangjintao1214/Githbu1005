<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2020/10/5
  Time: 13:52
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
<form action="/doupd" method="post">
    <table border="1px" align="center" width="500px">
        <tr>
            <td colspan="8" align="center"><h2>申报项目信息</h2></td>
        </tr>
        <tr>
            <td>项目编号：</td>
            <td><input type="text" value="${projectinfo.id}" name="id"></td>
        </tr>
        <tr>
            <td>项目名称：</td>
            <td><input type="text" value="${projectinfo.projectname}" name="projectname"></td>
        </tr>
        <tr>
            <td>申报开始时间：</td>
            <td><input type="text" value="${projectinfo.startdate}" name="startdate"></td>
        </tr>
        <tr>
            <td>申报结束时间：</td>
            <td><input type="text" value="${projectinfo.enddate}" name="enddate"></td>
        </tr>
        <tr>
            <td>申报状态：</td>
            <td>
                <select name="status">
                    <option <c:if test="${projectinfo.status==0}"> selected </c:if> value="0">已申报</option>
                    <option <c:if test="${projectinfo.status==1}"> selected </c:if> value="1">审核中</option>
                    <option <c:if test="${projectinfo.status==2}"> selected </c:if> value="2">已审核</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <input type="submit" value="修改">
                <input type="button" value="返回" onclick="javascript:history.back(-1)">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script type="text/javascript">
$("tr.td.next").css("background-color","pink");
</script>
