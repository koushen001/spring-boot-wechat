<%--
  Created by IntelliJ IDEA.
  User: CIKE
  Date: 2017/9/14
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="${path}/WEB-INF/jsp/common/common.jsp"/>
    <title>首页</title>
</head>
<body>
<jsp:include page="${path}/WEB-INF/jsp/common/header.jsp"/>
<div class="container">
    <div class="starter-template">
        <div class="row">
            <div class="col-sm-12">
                <div class="thumbnail">
                    <img class="img-rounded" src="${current_user.headimgurl}">
                    <div class="caption">
                        <h4><span>昵称：</span><span class="label label-primary">${current_user.nickname}</span></h4>
                        <h4><span>性别：</span><span class="label label-success">${current_user.sex==1?"男":"女"}</span></h4>
                        <h4><span>国家：</span><span class="label label-info">${current_user.country}</span></h4>
                        <h4><span>省份：</span><span class="label label-warning">${current_user.province}</span></h4>
                        <h4><span>城市：</span><span class="label label-danger">${current_user.city}</span></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
