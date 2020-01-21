package game.racinggame;

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
                            new RacingCar(dto.getTryCount(), dto.getCarNames().get(i))
                        )
                );
    }

    int getRacingCarsCount(){
        return racingCars.size();
    }

    void go(){
        racingCars.forEach(RacingCar::move);
    }

    List<List<String>> getTraces() {

        final List<List<String>> tracesList = new ArrayList<>();

        racingCars.forEach(racingCar ->
                tracesList.add(racingCar.getTraces()));

        return tracesList;
    }
}
