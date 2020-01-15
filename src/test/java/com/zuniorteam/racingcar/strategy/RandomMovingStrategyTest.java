package com.zuniorteam.racingcar.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovingStrategyTest {

    @Test
    void isMoving() {
        final MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        assertThat(randomMovingStrategy.isMoving()).isFalse();
    }
}
