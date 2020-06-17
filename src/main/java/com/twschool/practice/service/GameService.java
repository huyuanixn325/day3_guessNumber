package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述 : TODO
 *
 * @Author : 于爽
 * @Email : yushuang@zybank.com.cn
 * @Date : 2020/6/17 16:41
 */
public class GameService {

    private GuessNumberGame guessNumberGame;

   public GameService(GuessNumberGame guessNumberGame) {
       this.guessNumberGame = guessNumberGame;
   }

   public String guess(String userAnswerString) {
       List<String> userAnswer = Arrays.asList(userAnswerString.split(" "));
       return guessNumberGame.guess(userAnswer);
   }

    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void setGuessNumberGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }


}