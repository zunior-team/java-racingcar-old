package game.racinggame;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RacingRankingMachine {

    private RacingRankingMachine(){}

    public static String showRanking(final List<RacingCar> cars) {

        final Optional<RacingCar> topRacingOption = cars.stream()
                .max(Comparator.comparingInt(RacingCar::getMyLastTracesLength));

        final int maxTraces = topRacingOption.orElseGet(RacingCar::createEmptyRacingCar)
                .getMyLastTracesLength();

        final StringBuilder sb = new StringBuilder();

        cars.stream()
                .filter(racingCar -> racingCar.getMyLastTracesLength() >= maxTraces)
                .forEach(racingCar -> sb.append(racingCar.getName()).append(", "));

        return removeLastComma(sb) + "가 최종 우승 했습니다.";
    }

    private static String removeLastComma(final StringBuilder sb) {
        return sb.substring(0, sb.length() - 2);
    }
}
