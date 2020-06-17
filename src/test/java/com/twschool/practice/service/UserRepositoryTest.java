package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * 功能描述 : TODO
 *
 * @Author : 于爽
 * @Email : yushuang@zybank.com.cn
 * @Date : 2020/6/17 20:57
 */
public class UserRepositoryTest {
    @Test
    public void should_return_userInfo() {
        // given
        UserInfo userInfo = new UserInfo("ys",new GuessNumberGame(new RandomAnswerGenerator()),0,0);
        UserRepository userRepository = new UserRepository();

        // when
        userRepository.setUserInfo("ys",userInfo);

        //then
        UserInfo result = userRepository.getUserInfoById("ys");
        Assert.assertNotNull(result);
        Assert.assertEquals(0,result.getScore());

    }

}