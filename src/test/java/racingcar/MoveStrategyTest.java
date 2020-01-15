package racingcar;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import racingcar.strategy.RandomMoveStrategy;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static racingcar.strategy.RandomMoveStrategy.MOVE_CRITERIA;

@ExtendWith(MockitoExtension.class)
public class MoveStrategyTest {
    @Mock
    private Random random;

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 5, 9})
    void moveStrategyTest(int randomNumber) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(random);

        given(random.nextInt(anyInt())).willReturn(randomNumber);

        assertThat(randomMoveStrategy.isMovable()).isEqualTo(randomNumber >= MOVE_CRITERIA);
    }
}
