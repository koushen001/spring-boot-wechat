package com.cike.task;

import com.cike.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
//public class MyTask {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);
//
//    @Autowired
//    private DeviceService deviceService;
//
//    @Scheduled(cron="0/6 * * * * ? ")
//    public void emailTask() {
//        //查询所有需要发送邮件的设备
//        //发送邮件
//        //改变设备邮件发送状态
//        LOGGER.info("定时任务开始执行");
//    }
//}
