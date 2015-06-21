package com.priyo.registration.dao;

import com.priyo.registration.domain.User;

import com.priyo.registration.util.DatabaseTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by panthotanvir on 6/21/15.
 */
public class UserDaoImp implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImp.class);

    public static Logger getLog() {
        return log;
    }


    @Override
    public void register(User user) {
        log.debug("database e dhukse");
        String insertQuery = "INSERT INTO `priyo`.`user` (`user_name`,  `email`, `password`,`phone`,`dob`)" +
                " VALUES (?, ?, ?, ?, ?);";

        String userName = user.getUser_name();
        String email = user.getEmail();
        String password = user.getPassword();
        String phoneNo = user.getPhoneNo();
        String date = user.getDob();


        log.debug("name---> {}", userName);
        log.debug("name---> {}", email);
        log.debug("name---> {}", userName);
        log.debug("name---> {}", password);
        log.debug("name---> {}", phoneNo);
        DatabaseTemplate.executeInsertQuery(insertQuery, userName, email, password, phoneNo, date);
        log.debug("User inserted");

    }


}