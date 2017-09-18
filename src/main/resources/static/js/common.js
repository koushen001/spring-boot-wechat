$(function () {
    var email = $(".email").val();
    if (email == "" || email == null) {
        $.ajax({
            type: "GET",
            url: "/device/queryEmail",
            success: function (result) {
                if (result != "" && result != null) {
                    $(".email").val(result);
                }
            }
        });
    }
});

function deleteDevice(result, id) {
    //询问框
    layer.open({
        content: '您确定要删除本设备吗？'
        , btn: ['确定', '取消']
        , yes: function (index) {
            $.ajax({
                type: "GET",
                url: "/device/delete/" + id,
                success: function (msg) {
                    $(result).parents(".tr").remove();
                }
            });
            layer.close(index);
        }
    });
}

function checkForm() {
    var deviceName = $(".deviceName").val();
    var expireDate = $(".expireDate").val();
    var remindDate = $(".remindDate").val();
    var checkType = $(".checkType").val();
    var useStatus = $(".useStatus").val();
    var email = $(".email").val();
    if (deviceName == "" || deviceName == null) {
        //提示
        layer.open({
            content: '请填写设备名称'
            , skin: 'msg'
            , time: 2 //2秒后自动关闭
        });
        $(".deviceName").focus();
        return;
    }
    if (checkType == 0) {
        //提示
        layer.open({
            content: '请选择校类型'
            , skin: 'msg'
            , time: 2 //2秒后自动关闭
        });
        $(".checkType").focus();
        return;
    }
    if (useStatus == 0) {
        //提示
        layer.open({
            content: '请选择使用状态'
            , skin: 'msg'
            , time: 2 //2秒后自动关闭
        });
        $(".useStatus").focus();
        return;
    }
    if (expireDate == "" || expireDate == null) {
        //提示
        layer.open({
            content: '请选择到期日期'
            , skin: 'msg'
            , time: 2 //2秒后自动关闭
        });
        $(".expireDate").focus();
        return;
    }
    if (remindDate == "" || remindDate == null) {
        //提示
        layer.open({
            content: '请选择提醒日期'
            , skin: 'msg'
            , time: 2 //2秒后自动关闭
        });
        $(".remindDate").focus();
        return;
    }
    if (!isEmail(email)) {
        //提示
        layer.open({
            content: '请填写正确的提醒邮箱'
            , skin: 'msg'
            , time: 2 //2秒后自动关闭
        });
        $(".email").focus();
        return;
    }
    $(".device-save").submit();
}

function isEmail(mail) {
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(mail)) {
        return true;
    } else {
        return false;
    }
}