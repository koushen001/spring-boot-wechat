package com.cike.service.impl;

import com.cike.dao.DeviceRepository;
import com.cike.entity.Device;
import com.cike.service.DeviceService;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 16:01
 **/
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device findOne(Long id) {
        return deviceRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        deviceRepository.delete(id);
    }

    @Override
    public void save(Device device) {
        if (device.getId() == null) {
            device.setCreateTime(new Date());
        }
        device.setIsSendEmail(0);
        device.setUpdateTime(new Date());
        deviceRepository.save(device);
    }

    @Override
    public List<Device> findByOpenId(String openid) {
        return deviceRepository.findByOpenId(openid);
    }

    @Override
    public String findEmailByOpenId(String openid) {
        return deviceRepository.findEmailByOpenId(openid);
    }

    @Override
    public List<Device> findByIsSendEmailAndRemindDate() {
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        return deviceRepository.findByIsSendEmailAndRemindDate(0, today);
    }

    @Transactional
    @Override
    public void updateSendStatus(Device device) {
        deviceRepository.updateSendStatus(device.getId());
    }
}
