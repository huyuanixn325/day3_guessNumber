package com.twschool.practice.service;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.UserInfo;

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
    private UserInfo userInfo;

    public GameService(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.guessNumberGame = userInfo.getGuessNumberGame();
    }


    public String guess(String userAnswerString) {
        List<String> userAnswerNumbers = Arrays.asList(userAnswerString.split(" "));
        Answer userAnswer = new Answer(userAnswerNumbers);
        if (!userAnswer.isValidFormat()) {
            return "Wrong Input，Input again";
        }
        return guessNumberGame.guess(userAnswerNumbers);
    }

    public int countScore() {
        if (guessNumberGame.getStatus() == GameStatus.FAILED) {
           userInfo.addScore(-3);
           userInfo.initWinCount();

        } else if (guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            userInfo.addScore(3);
            userInfo.addWinCount();
            if(userInfo.getWinCount()%5==0){
                userInfo.addScore(3);
            }else if(userInfo.getWinCount()%3==0){
                userInfo.addScore(2);
            }
        }
        return userInfo.getScore();
    }

    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void setGuessNumberGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }


}