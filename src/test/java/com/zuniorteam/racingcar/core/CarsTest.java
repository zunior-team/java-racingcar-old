package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

class CarsTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new Cars(10));
    }

    @DisplayName("생성, 자동차 개수가 0 이하")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void testNewInstance01(int numberOfCars) {
        assertThrows(RuntimeException.class, () -> new Cars(numberOfCars));
    }

    @DisplayName("생성, 모든 자동차 현재 위치 가져오기")
    @Test
    void testGetCurrentPosition() {
        //given
        final int numberOfCars = 100;
        final Cars cars = new Cars(numberOfCars);

        final MovingStrategy movingStrategy = Mockito.mock(MovingStrategy.class);
        given(movingStrategy.isMovable()).willReturn(true);

        //when
        final List<Integer> currentPositions = cars.getCurrentPositions();

        assertThat(currentPositions.size()).isEqualTo(numberOfCars);
    }


    @DisplayName("생성, 모든 자동차 이동")
    @Test
    void testMoveAll() {
        //given
        final int numberOfCars = 1;
        final Cars cars = new Cars(numberOfCars);

        final MovingStrategy movingStrategy = Mockito.mock(MovingStrategy.class);
        given(movingStrategy.isMovable()).willReturn(true);


        //when
        cars.moveAll(movingStrategy);
        final List<Integer> currentPositions = cars.getCurrentPositions();

        //then
        assertThat(currentPositions.size()).isEqualTo(numberOfCars);
        assertThat(currentPositions.get(0)).isEqualTo(1);
    }
}
