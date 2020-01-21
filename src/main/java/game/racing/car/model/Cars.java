package game.racing.car.model;

import game.racing.car.model.vo.CarDto;
import game.racing.car.service.impl.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomMovingStrategy()));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarDto> getDtos() {
        return cars.stream()
                .map(car -> car.makeCarDto())
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        List<CarDto> carDtos = getDtos();

        Integer winnerScore = carDtos.stream()
                .mapToInt(carDto -> carDto.getPosition())
                .max()
                .orElseThrow(() -> new RuntimeException("Unexpected Error."));

        return carDtos.stream()
                .filter(carDto -> winnerScore.equals(carDto.getPosition()))
                .map(carDto -> carDto.getCarName())
                .collect(Collectors.toList());
    }
}
