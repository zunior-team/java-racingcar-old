package game.racinggame;

import game.racinggame.strategy.RandomMovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();

    RacingCars() {}

    void setUpRacing(final Object obj){

        final RacingDataTransferObject dto = (RacingDataTransferObject) obj;

        IntStream.range(0, dto.getCarNumber())
                .forEach(i -> racingCars.add(
                        new RacingCar(
                                getTryCountByDto(dto),
                                getNameByDto(dto, i),
                                new RandomMovementStrategy())));
    }

    private int getTryCountByDto(final RacingDataTransferObject dto){
        return dto.getTryCount();
    }

    private String getNameByDto(final RacingDataTransferObject dto, final int index){
        return dto.getCarNames()
                .get(index);
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
