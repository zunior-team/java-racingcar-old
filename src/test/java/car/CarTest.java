package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차에")
public class CarTest {

    private int tryCount = 0;
    private List<RacingCarTest> racingCars = new ArrayList<>();

    @ParameterizedTest(name = "자동차 {0}대 생성, {1}대 생성완료")
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3"
    })
    @DisplayName("대수를 결정한다.")
    void initRacingCarNumberTest(final int number, final int expectSize) {

        // given & when
        for(int i = 0; i < number; i++) {
            racingCars.add(new RacingCarTest());
        }

        // then
        assertThat(racingCars.size()).isEqualTo(expectSize);
    }

    @ParameterizedTest(name = "자동차 시도 횟수 {0}회 요청, {1}회 초기화")
    @CsvSource({
            "1, 1",
            "10, 10",
            "500, 500"

    })
    @DisplayName("시도할 횟수를 결정한다.")
    void initRacingCarTryCountTest(final int tryCount, final int expectTryCount) {

//        // given & when
//        this.tryCount = tryCount;
//
//        // then
//        assertThat(this.tryCount).isEqualTo(expectTryCount);
    }

}
