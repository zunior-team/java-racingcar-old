package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.gui.RacingGameBoard;

public class Main {

    public static void main(String[] args){
        final MovingStrategy movingStrategy = new RandomMovingStrategy();
        new RacingGameBoard(movingStrategy).listen();
    }
}
