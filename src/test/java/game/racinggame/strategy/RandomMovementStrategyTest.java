package game.racinggame.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("랜덤 이동 전략은")
class RandomMovementStrategyTest {

    @Mock
    private MovementStrategy strategy;

    @ParameterizedTest
    @MethodSource("provideRandomInt")
    @DisplayName("아무 숫자를 내보낸다.")
    void movementStrategy(final int random){

        // given
        given(strategy.getNumberByStrategy()).willReturn(random);

        // when
        final int randomValue = strategy.getNumberByStrategy();

        // then
        assertThat(randomValue).isEqualTo(random);
    }

    static Stream<Integer> provideRandomInt(){
        return Stream.of(
                1,
                2
        );
    }
}