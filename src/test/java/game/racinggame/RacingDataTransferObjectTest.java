package game.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 경주게임 시작시")
class RacingDataTransferObjectTest {

    @ParameterizedTest
    @MethodSource("provideDto")
    @DisplayName("자동차 이름을 획득한다.")
    void getCarNamesTest(final List<String> carNames, final int tryCount, final List<String> expectCarNames) {

        // given & when
        final RacingDataTransferObject dto = new RacingDataTransferObject(carNames, tryCount);

        assertAll("RacingCar",
                () -> assertEquals(carNames.get(0), expectCarNames.get(0)),
                () -> assertEquals(carNames.get(1), expectCarNames.get(1))
        );
    }

    @ParameterizedTest
    @MethodSource("provideDto")
    @DisplayName("자동차 대수를 획득한다.")
    void getCarNumberTest(final List<String> carNames, final int tryCount, final List<String> expectCarNames) {

        // given & when
        final RacingDataTransferObject dto = new RacingDataTransferObject(carNames, tryCount);

        // then
        assertThat(dto.getCarNumber()).isEqualTo(expectCarNames.size());
    }

    @ParameterizedTest
    @MethodSource("provideDto")
    @DisplayName("시도할 회수를 횟득한다.")
    void getTryCountTest(final List<String> carNames, final int tryCount, final List<String> expectCarNames) {

        // given & when
        final RacingDataTransferObject dto = new RacingDataTransferObject(carNames, tryCount);

        // then
        assertThat(dto.getTryCount()).isEqualTo(tryCount);
    }

    static Stream<Arguments> provideDto(){

        return Stream.of(
                Arguments.of(Arrays.asList("아반떼", "소나타"), 3, Arrays.asList("아반떼", "소나타")),
                Arguments.of(Arrays.asList("산타페", "제네시스"), 5, Arrays.asList("산타페", "제네시스"))
        );
    }
}