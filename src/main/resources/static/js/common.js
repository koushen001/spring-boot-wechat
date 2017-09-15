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
    if (deviceName==""||deviceName==null){
        //提示
        layer.open({
            content: '请填写设备名称'
            ,skin: 'msg'
            ,time: 2 //2秒后自动关闭
        });
        $(".deviceName").focus();
        return;
    }
    if (expireDate==""||expireDate==null){
        //提示
        layer.open({
            content: '请选择提醒日期'
            ,skin: 'msg'
            ,time: 2 //2秒后自动关闭
        });
        $(".expireDate").focus();
        return;
    }
    if (remindDate==""||remindDate==null){
        //提示
        layer.open({
            content: '请选择到期日期'
            ,skin: 'msg'
            ,time: 2 //2秒后自动关闭
        });
        $(".remindDate").focus();
        return;
    }
    $(".device-save").submit();
}
