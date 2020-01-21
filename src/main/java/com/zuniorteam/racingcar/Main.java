package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.view.console.ConsoleGameInputView;
import com.zuniorteam.racingcar.view.console.ConsoleGameResultView;
import com.zuniorteam.racingcar.view.GameInputView;
import com.zuniorteam.racingcar.view.GameResultView;

public class Main {

    public static void main(String[] args){
        final GameInputView gameInputView = new ConsoleGameInputView();
        final GameResultView gameResultView = new ConsoleGameResultView();
        final MovingStrategy movingStrategy = new RandomMovingStrategy();

        new RacingGameBoard(gameInputView, gameResultView).start(movingStrategy);
    }
}
