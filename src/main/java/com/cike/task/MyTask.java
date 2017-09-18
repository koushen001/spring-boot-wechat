package com.cike.task;

import com.cike.entity.Device;
import com.cike.service.DeviceService;
import com.cike.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private EmailUtil emailUtil;

    @Scheduled(cron = "0 0 8 * * ?")
    public void emailTask() {
        //查询所有需要发送邮件的设备
        List<Device> list = deviceService.findByIsSendEmailAndRemindDate();
        LOGGER.info("需要发送邮件提醒的设备：{}", list.size());
        //发送邮件
        for (Device device : list) {
            String email = device.getEmail();
            StringBuffer title = new StringBuffer();
            StringBuffer content = new StringBuffer();
            title.append("设备名称为：")
                    .append(device.getDeviceName())
                    .append("的设备快到期了");
            content.append("<h3>设备名称：").append(device.getDeviceName()).append("</h3>")
                    .append("<h3>设备编号：").append(device.getDeviceNo()).append("</h3>")
                    .append("<h3>到期日期：").append(device.getExpireDate()).append("</h3>");
            emailUtil.sendHtmlMail(email, title.toString(), content.toString());
            deviceService.updateSendStatus(device);
        }
        LOGGER.info("定时任务开始执行");
    }
}
