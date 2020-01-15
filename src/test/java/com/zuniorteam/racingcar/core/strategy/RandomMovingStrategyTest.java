package com.zuniorteam.racingcar.core.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovingStrategyTest {

    @Test
    void isMoving() {
        final com.zuniorteam.racingcar.core.strategy.MovingStrategy randomMovingStrategy = new com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy();

        assertThat(randomMovingStrategy.isMoving()).isFalse();
    }
}
