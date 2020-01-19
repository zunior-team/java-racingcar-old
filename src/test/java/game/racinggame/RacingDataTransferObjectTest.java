package game.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("자동차 경주게임 시작시")
class RacingDataTransferObjectTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2"
    })
    @DisplayName("자동차 대수를 획득한다.")
    void getCarNumberTest(final int carNumber, final int tryCount) {

        // given & when
        final RacingDataTransferObject dto = new RacingDataTransferObject(carNumber, tryCount);

        // then
        assertThat(dto.getCarNumber()).isEqualTo(carNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2"
    })
    @DisplayName("시도할 회수를 횟득한다.")
    void getTryCountTest(final int carNumber, final int tryCount) {

        // given & when
        final RacingDataTransferObject dto = new RacingDataTransferObject(carNumber, tryCount);

        // then
        assertThat(dto.getTryCount()).isEqualTo(tryCount);
    }
}