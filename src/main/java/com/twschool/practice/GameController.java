package com.twschool.practice;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    private GameService gameService;

    @GetMapping("/game")
    public Map<String,String> guess(@RequestParam String guess) {
        Map<String,String> map = new HashMap<>();

        map.put("input",guess);
        map.put("result",gameService.guess(guess));
        return map;
    }

    @GetMapping("/history")
    public Map<String,String> history() {
        Map<String,String> map = new HashMap<>();
        map.put("result","Input:1 2 3 4    Output:4A0B");
        return map;
    }
}