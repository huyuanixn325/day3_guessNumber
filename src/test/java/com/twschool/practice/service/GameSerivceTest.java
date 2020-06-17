//package com.twschool.practice.service;
//
//import com.twschool.practice.domain.Answer;
//import com.twschool.practice.domain.GuessNumberGame;
//import com.twschool.practice.domain.RandomAnswerGenerator;
//import org.junit.Assert;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.Arrays;
//
///**
// * 功能描述 : TODO
// *
// * @Author : 于爽
// * @Email : yushuang@zybank.com.cn
// * @Date : 2020/6/17 17:06
// */
//public class GameSerivceTest {
//
//
//
//    @Test
//    public void should_return_guess_result() {
//        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
//        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(new Answer(Arrays.asList("1","2","3","4")));
//        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
//        GameService gameService = new GameService(guessNumberGame);
//
//        String result = gameService.guess("1 2 3 4");
//
//        Assert.assertNotNull(result);
//        Assert.assertEquals("4A0B",result);
//
//
//    }
//
//    @Test
//    public void should_start_game_when_guess_unmber() {
//       GameService gameService = Mockito.mock(GameService.class);
//       RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
//       Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(new Answer(Arrays.asList("1","2","3","4")));
//       GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
//
//       Mockito.when(gameService.getGuessNumberGame()).thenReturn(guessNumberGame);
//       Mockito.when(gameService.guess(Mockito.any())).thenCallRealMethod();
//
//       gameService.guess("1 2 3 4");
//
//       Mockito.verify(gameService,Mockito.times(1)).
//
//
//    }
//}