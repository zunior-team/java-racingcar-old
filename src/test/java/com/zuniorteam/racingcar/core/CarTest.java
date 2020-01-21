package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.vo.MoveHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

class CarTest {

    @DisplayName("Car 생성")
    @Test
    void testNewInstance01(){
        assertDoesNotThrow( () -> new Car("hello"));
    }

    @DisplayName("Car 생성, 차 이름이 없을 때")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void testNewInstance02(String carName){
        assertThrows( RuntimeException.class, () -> new Car(carName));
    }

    @DisplayName("move 테스트")
    @Test
    void testMove01(){
        //given
        final String carName = "helloCar";
        final Car car = new Car(carName);
        final MovingStrategy mockMovingStrategy = Mockito.mock(MovingStrategy.class);
        given(mockMovingStrategy.isMovable()).willReturn(true);

        //when
        car.move(mockMovingStrategy);
        final int position = car.getPosition();


        //then
        assertThat(position).isEqualTo(1);
    }

}
