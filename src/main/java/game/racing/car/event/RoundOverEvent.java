package game.racing.car.event;

import game.racing.car.model.vo.CarDto;

import java.util.List;

public class RoundOverEvent {
    private List<CarDto> carDtos;

    public RoundOverEvent(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }
}
