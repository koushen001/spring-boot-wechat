package com.cike.dao;

import com.cike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 14:16
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    User findByopenid(String openid);
}
