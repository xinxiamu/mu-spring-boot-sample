package com.example.demo.all;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllServiceImpl implements AllService {

    private static final Logger logger = LoggerFactory.getLogger(AllServiceImpl.class);

    @Autowired
    private AllDao allDao;

    @Override
    public Integer save(Integer userId, String userName, Integer age) {
        UserInfo r = allDao.save(userId, userName, age);
        return r.getId();
    }

    @Override
    public Boolean update(Integer userId, String userName) {
        UserInfo userInfo = allDao.update(userId, userName);
        return userName.equals(userInfo.getName()) ? true : false;
    }

    @Override
    public String get(Integer userId) {
        return allDao.get(userId).getName();
    }
}
