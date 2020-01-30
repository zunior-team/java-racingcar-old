package game.racinggame;

import game.racinggame.dto.RacingCreateDto;
import game.racinggame.strategy.RandomMovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();

    RacingCars() {}

    void setUpRacing(final RacingCreateDto dto){

        final int carsSize = dto.getCarNames().size();

        IntStream.range(0, carsSize)
                .forEach(i -> racingCars.add(
                        new RacingCar(
                                dto.getTryCount(),
                                dto.getCarNames().get(i),
                                new RandomMovementStrategy())));
    }

    int getRacingCarsCount(){
        return racingCars.size();
    }

    void go(){
        racingCars.forEach(RacingCar::move);
    }

    List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
