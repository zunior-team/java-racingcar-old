package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.Car;
import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

class CarTest {

    @DisplayName("Car 생성")
    @Test
    void testNewInstance(){
        assertDoesNotThrow(Car::newInstance);
    }

    @DisplayName("move 테스트")
    @Test
    void testMove01(){
        //given
        final Car car = Car.newInstance();
        final MovingStrategy mockMovingStrategy = Mockito.mock(MovingStrategy.class);
        given(mockMovingStrategy.isMoving()).willReturn(true);

        //when
        final int result = car.move(mockMovingStrategy);

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("Move, 전략이 null 일 때")
    @Test
    void testMove02(){
        final Car car = Car.newInstance();
        assertThrows(AssertionError.class, () -> car.move(null));
    }

}
