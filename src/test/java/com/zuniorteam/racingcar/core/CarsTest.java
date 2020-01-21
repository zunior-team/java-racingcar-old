package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.vo.MoveHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

class CarsTest {

    @DisplayName("New Instance")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new Cars(Collections.singletonList("helloCar")));
    }

    @DisplayName("New Instance, 자동차 이름이 없을 때")
    @Test
    void testNewInstance02() {
        assertThrows(RuntimeException.class, () -> new Cars(Collections.emptyList()));
    }


    @DisplayName("moveAll()")
    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void testMoveAll(boolean isMovable, int position) {
        //given
        final String carName = "one";
        final List<String> carNames = Collections.singletonList(carName);
        final Cars cars = new Cars(carNames);

        final MovingStrategy movingStrategy = Mockito.mock(MovingStrategy.class);
        given(movingStrategy.isMovable()).willReturn(isMovable);

        //when
        final List<MoveHistory> moveHistories = cars.moveAll(movingStrategy);


        //then
        assertThat(moveHistories.size()).isEqualTo(carNames.size());
        assertThat(moveHistories.get(0)).isEqualTo(new MoveHistory(carName, position));
    }
}
