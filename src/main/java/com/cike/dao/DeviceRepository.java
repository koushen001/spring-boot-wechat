package com.cike.dao;

import com.cike.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 14:16
 **/
public interface DeviceRepository extends JpaRepository<Device, Long> {
    /**
     * 根据openid查询其所有设备
     *
     * @param openid
     * @return
     */
    List<Device> findByOpenId(String openid);

    /**
     * 查询该员工的邮箱
     */
    @Query(value = "SELECT email FROM device d WHERE d.is_send_email = 0 AND d.open_id = ?1 ORDER BY update_time DESC LIMIT 1", nativeQuery = true)
    String findEmailByOpenId(String openid);

    /**
     * 查询所有待发邮件提醒的设备
     */
    List<Device> findByIsSendEmailAndRemindDate(Integer isSendEmail, String remindDate);

    @Modifying
    @Query(value = "UPDATE device SET is_send_email = 1,update_time = NOW() WHERE id = ?1", nativeQuery = true)
    void updateSendStatus(Long id);
}
