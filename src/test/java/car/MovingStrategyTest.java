package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import util.RandomParametersExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(RandomParametersExtension.class)
@DisplayName("자동차 이동전략은")
class MovingStrategyTest {

    @RepeatedTest(100)
    @DisplayName("10 미만의 랜덤 이동 전략을 사용한다.")
    void getValueByRandomStrategyTest(@RandomParametersExtension.Random int value) {

        // given & when

        // then
        assertThat(value).isLessThan(10);
    }
}
