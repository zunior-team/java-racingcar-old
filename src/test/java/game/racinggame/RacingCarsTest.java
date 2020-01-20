package game.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("레이싱 카는")
class RacingCarsTest {

    @ParameterizedTest
    @MethodSource("provideRacingDto")
    @DisplayName("레이싱 전에 세팅시킨다.")
    void setUpRacingTest(final RacingDataTransferObject dto) {

        // given
        RacingCars racingCars = new RacingCars();
        racingCars.setUpRacing(dto);

        // when
        final int carNumber = racingCars.getRacingCarsCount();

        // then
        assertThat(carNumber).isEqualTo(dto.getCarNumber());
    }

    @ParameterizedTest
    @MethodSource("provideRacingDto")
    @DisplayName("간다.")
    void go(final RacingDataTransferObject dto) {

        RacingCars racingCars = new RacingCars();
        racingCars.setUpRacing(dto);
    }

    private static Stream<RacingDataTransferObject> provideRacingDto(){

        return Stream.of(
                new RacingDataTransferObject(1, 1),
                new RacingDataTransferObject(3, 10),
                new RacingDataTransferObject(5, 2)
        );
    }
}