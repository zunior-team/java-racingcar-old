package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.gui.RacingGameBoard;
import com.zuniorteam.racingcar.gui.drawer.SimplePositionDrawer;

public class Main {

    public static void main(String[] args){
        final MovingStrategy movingStrategy = new RandomMovingStrategy();
        final SimplePositionDrawer lineDrawer = new SimplePositionDrawer();

        new RacingGameBoard(movingStrategy, lineDrawer).listen();
    }
}
