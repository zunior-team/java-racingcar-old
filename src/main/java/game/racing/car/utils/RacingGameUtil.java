package game.racing.car.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class RacingGameUtil {

    private static final String COMMA_DELIMITER = ",";

    public static String[] separateCarNames(String line) {
        String[] test= line.split(COMMA_DELIMITER);
        return test;
    }

    public static Boolean isAllNotEmpty(String[] strings) {
        return !Arrays.stream(strings)
                .anyMatch(carName -> StringUtils.isEmpty(carName));
    }
}
