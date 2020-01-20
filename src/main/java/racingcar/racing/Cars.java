package racingcar.racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> cars;

    public Cars(int numberOfCars) {
        if(numberOfCars < 0) {
            throw new IllegalArgumentException("Number of cars must be positive");
        }

        this.cars = IntStream.range(0, numberOfCars)
                .mapToObj(x -> new Car())
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public String showCurrentState() {
        StringBuilder stringBuilder = new StringBuilder();

        cars.forEach(car ->
                stringBuilder.append(car.printPosition())
                        .append('\n')
        );

        return stringBuilder.toString();
    }
}
