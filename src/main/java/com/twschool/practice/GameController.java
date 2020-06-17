package com.twschool.practice;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.domain.UserInfo;
import com.twschool.practice.service.GameService;
import com.twschool.practice.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述 : TODO
 *
 * @Author : 于爽
 * @Email : yushuang@zybank.com.cn
 * @Date : 2020/6/17 16:25
 */
@RestController
public class GameController {

    @Autowired
    private UserRepository userRepository;


    private GameService gameService;

    @GetMapping("/game/{userId}")
    public Map<String, String> guess(@PathVariable String userId, @RequestParam String guess) {
        UserInfo userInfo = userRepository.getUserInfoById(userId);
        if (userInfo == null) {
            GuessNumberGame guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator());
            userInfo = new UserInfo(userId, guessNumberGame, 0, 0);
            userRepository.setUserInfo(userId, userInfo);
        } else {
            if (userInfo.getGuessNumberGame().getStatus() != GameStatus.CONTINUED) {
                userInfo.setGuessNumberGame(new GuessNumberGame(new RandomAnswerGenerator()));
            }
        }
        gameService = new GameService(userInfo);

        Map<String, String> map = new HashMap<>();

        map.put("input", guess);
        map.put("output", gameService.guess(guess));
        map.put("score", gameService.countScore() + "");
        return map;
    }

    @GetMapping("/history")
    public Map<String, String> history() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "Input:1 2 3 4    Output:4A0B");
        return map;
    }
}