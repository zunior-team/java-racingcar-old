import java.util.stream.IntStream;

public class Car {
    public static final String DASH_MARK = "-";
    private Integer position = 0;

    public void move() {
        position++;
    }

    public String printPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, position)
                .forEach((x) -> stringBuilder.append(DASH_MARK));

        return stringBuilder.toString();
    }
}
