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
    <script src="${path}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="${path}/WEB-INF/jsp/common/header.jsp"/>
<div class="container">
    <div class="starter-template">
        <div class="panel panel-success">
            <div class="panel-heading">设备管理</div>
            <div class="panel-body">
                <form class="form-horizontal device-save" method="post" action="${path}/device/save">
                    <input type="hidden" name="id" value="${device.id}">
                    <div class="form-group">
                        <label class="col-xs-4 control-label">设备编号：</label>
                        <div class="col-xs-8">
                            <input name="deviceNo" value="${device.deviceNo}" type="text" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">设备名称：</label>
                        <div class="col-xs-8">
                            <input name="deviceName" value="${device.deviceName}" type="text" class="form-control deviceName"
                                   placeholder="必填">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">设备描述：</label>
                        <div class="col-xs-8">
                            <textarea name="deviceDescribe" class="form-control"
                                      rows="3">${device.deviceDescribe}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">到期日期：</label>
                        <div class="col-xs-8">
                            <input name="expireDate" value="${device.expireDate}" class="form-control expireDate" type="text"
                                   onClick="WdatePicker()" placeholder="必填"
                                   readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">提醒日期：</label>
                        <div class="col-xs-8">
                            <input name="remindDate" value="${device.remindDate}" type="text" class="form-control remindDate"
                                   onClick="WdatePicker()" placeholder="必填"
                                   readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-4 col-xs-8">
                            <button type="button" onclick="checkForm()" class="btn btn-success">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
