package com.twschool.practice.service;

import com.twschool.practice.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述 : TODO
 *
 * @Author : 于爽
 * @Email : yushuang@zybank.com.cn
 * @Date : 2020/6/17 20:11
 */
@Service
public class UserRepository {
    private Map<String, UserInfo> userRepositoryMap = new HashMap<>();

    public UserInfo getUserInfoById(String id) {
        return userRepositoryMap.get(id);

    }

    public void setUserInfo(String id, UserInfo userInfo) {
        userRepositoryMap.put(id, userInfo);

    }
}