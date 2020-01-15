package car;

import java.util.ArrayList;
import java.util.List;

public final class Car {

    private List<RacingCar> racingCars = new ArrayList<>();

    public Car(){

    }

    public void initRacingCarNumber(final int number){
        for(int i = 0; i < number; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public void initRacingCarTryCount(final int tryCount) {
        racingCars.forEach(racingCar -> racingCar.setupTryCount(tryCount));
    }

    public void printResultTraveled(){
        racingCars.forEach(RacingCar::move);
    }
}
