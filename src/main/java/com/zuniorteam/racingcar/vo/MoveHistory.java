package com.zuniorteam.racingcar.vo;

import java.util.Objects;

public class MoveHistory {

    private final String carName;
    private final int position;

    public MoveHistory(String carName, int position) {
        assert carName != null;

        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveHistory that = (MoveHistory) o;
        return position == that.position &&
                Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
