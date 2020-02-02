package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommaSplitter {

    public static final String COMMA = ",";

    private CommaSplitter() {
    }

    public static List<String> split(String target) {
        return Arrays.stream(target.split(COMMA))
                .collect(Collectors.toList());
    }
}
