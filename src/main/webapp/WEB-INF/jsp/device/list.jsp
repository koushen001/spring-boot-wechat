<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: CIKE
  Date: 2017/9/14
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="${path}/WEB-INF/jsp/common/common.jsp"/>
    <title>设备列表</title>
</head>
<body>
<jsp:include page="${path}/WEB-INF/jsp/common/header.jsp"/>
<c:if test="${list.size()==0}">
    <div class="container">
        <div class="starter-template">
            <div class="jumbotron">
                <h1>没有设备信息</h1>
                <p>你好，你还没有录入设备信息，录入设备信息，设定提醒日期，设备到期后会发邮件提醒你。</p>
                <p><a class="btn btn-primary btn-lg" href="${path}/device/edit/0" role="button">去录入</a></p>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${list.size()>0}">
    <div class="panel panel-success">
        <div class="panel-heading">设备列表</div>
        <div class="panel-body">
            <a class="btn btn-success btn-xs pull-right" href="${path}/device/edit/0" role="button">添加</a>
            <table class="table">
                <thead>
                <tr>
                    <th>设备名称</th>
                    <th>到期日期</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="d" varStatus="status">
                    <tr class="tr">
                        <th scope="row"><a href="${path}/device/detail/${d.id}">${d.deviceName}</a></th>
                        <td>${d.expireDate}</td>
                        <td>
                            <a class="btn btn-info btn-xs" href="${path}/device/edit/${d.id}" role="button">修改</a>
                            <button onclick="deleteDevice(this,${d.id})" class="btn btn-danger btn-xs">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>
</body>
</html>
