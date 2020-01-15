package com.zuniorteam.racingcar.gui.drawer;

public class SimplePositionDrawer implements PositionDrawer {

    private static final String LINE = "-";

    @Override
    public String draw(int position) {
        final StringBuilder line = new StringBuilder();

        for (int i = 0; i < position; i++) {
            line.append(LINE);
        }

        return line.toString();
    }
}
