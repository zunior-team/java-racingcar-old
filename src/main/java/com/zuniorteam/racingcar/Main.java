package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.gui.RacingGameBoard;
import com.zuniorteam.racingcar.strategy.MovingStrategy;
import com.zuniorteam.racingcar.strategy.RandomMovingStrategy;

public class Main {

    public static void main(String[] args){
        final MovingStrategy movingStrategy = new RandomMovingStrategy();

        new RacingGameBoard(movingStrategy).listen();
    }
}
