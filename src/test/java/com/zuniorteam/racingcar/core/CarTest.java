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
        assertDoesNotThrow(Car::new);
    }

    @DisplayName("move 테스트")
    @Test
    void testMove01(){
        //given
        final Car car = new Car();
        final MovingStrategy mockMovingStrategy = Mockito.mock(MovingStrategy.class);
        given(mockMovingStrategy.isMoving()).willReturn(true);

        //when
        car.move(mockMovingStrategy);
        final int result = car.getPosition();

        //then
        assertThat(result).isEqualTo(1);
    }

}
