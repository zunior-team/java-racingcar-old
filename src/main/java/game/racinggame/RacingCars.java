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

        IntStream.range(0, dto.getCarSize())
                .forEach(index -> racingCars.add(
                        new RacingCar(
                                dto.getTryCount(),
                                dto.getCarNameByIndex(index),
                                new RandomMovementStrategy())));
    }

    int getRacingCarsCount(){
        return racingCars.size();
    }

    void go(){
        racingCars.forEach(RacingCar::move);
    }

    String getTracesByRound(final int round) {
        return null;
    }

    String getLastTraces(){
        return null;
    }

//    List<RacingCar> getRacingCars() {
//        return this.racingCars;
//    }
}
