package com.cike.dao;

import com.cike.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 14:16
 **/
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findByOpenId(String openid);
}
