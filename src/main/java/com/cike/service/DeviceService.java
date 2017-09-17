package com.cike.service;

import com.cike.entity.Device;

import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 16:01
 **/
public interface DeviceService {

    List<Device> findAll();

    Device findOne(Long id);

    void delete(Long id);

    void save(Device device);

    List<Device> findByOpenId(String openid);
}
