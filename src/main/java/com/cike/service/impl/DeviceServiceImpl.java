package com.cike.service.impl;

import com.cike.dao.DeviceRepository;
import com.cike.entity.Device;
import com.cike.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 16:01
 **/
@Service
public class DeviceServiceImpl implements DeviceService{

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
        deviceRepository.save(device);
    }

    @Override
    public List<Device> findByOpenId(String openid) {
        return deviceRepository.findByOpenId(openid);
    }
}
