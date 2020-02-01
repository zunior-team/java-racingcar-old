package game.racinggame;

import game.racinggame.dto.RacingCreateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("레이싱 카들은")
class RacingCarsTest {

    @ParameterizedTest
    @MethodSource("provideRacingCreateDto")
    @DisplayName("레이싱 전에 세팅된다.")
    void setUpRacingTest(final RacingCreateDto dto) {

        // given
        RacingCars racingCars = new RacingCars();
        racingCars.setUpRacing(dto);

        // when
        final int carNumber = racingCars.getRacingCarsCount();

        // then
        assertThat(carNumber).isEqualTo(dto.getCarSize());
    }

    @ParameterizedTest
    @MethodSource("provideRacingCreateDto")
    @DisplayName("앞으로 나아가며 흔적을 남긴다.")
    void go(final RacingCreateDto dto) {

        // given
        RacingCars racingCars = new RacingCars();
        racingCars.setUpRacing(dto);

        // when
        racingCars.go();

        // then
        
    }

    private static Stream<RacingCreateDto> provideRacingCreateDto() {

        return Stream.of(
                new RacingCreateDto("붕붕, 씽씽", 2)
        );
    }
}