<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container">
    <div class="starter-template">
        <div class="panel panel-success">
            <div class="panel-heading">设备管理</div>
            <div class="panel-body">
                <form enctype="multipart/form-data" class="form-horizontal device-save" method="post" action="${path}/device/save">
                    <div class="form-group">
                        <label class="col-xs-4 control-label">设备编号：</label>
                        <div class="col-xs-8">
                            <p>${device.deviceNo}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">设备名称：</label>
                        <div class="col-xs-8">
                            <P>${device.deviceName}</P>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">设备描述：</label>
                        <div class="col-xs-8">
                            <P>${device.deviceDescribe}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">校验类型：</label>
                        <div class="col-xs-8">
                            <P>
                                <c:if test="${device.checkType==1}">内部校验</c:if>
                                <c:if test="${device.checkType==2}">外部校验</c:if>
                            </P>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">使用状态：</label>
                        <div class="col-xs-8">
                            <p>
                                <c:if test="${device.useStatus==1}">正常使用</c:if>
                                <c:if test="${device.useStatus==2}">已停用</c:if>
                                <c:if test="${device.useStatus==3}">待维修</c:if>
                                <c:if test="${device.useStatus==4}">待报废</c:if>
                                <c:if test="${device.useStatus==5}">检验中</c:if>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">附件：</label>
                        <div class="col-xs-8">
                            <p>
                                <a href="${device.filePath}">下载</a>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">到期日期：</label>
                        <div class="col-xs-8">
                            <P>${device.expireDate}</P>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">提醒日期：</label>
                        <div class="col-xs-8">
                            <P>${device.remindDate}</P>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">提醒邮箱：</label>
                        <div class="col-xs-8">
                            <P>${device.email}</P>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-4 col-xs-8">
                            <a role="button" class="btn btn-success" href="${path}/device/list">返回</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
