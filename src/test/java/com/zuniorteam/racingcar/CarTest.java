package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        //when
        final int result = car.move(new RandomMovingStrategy());

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
