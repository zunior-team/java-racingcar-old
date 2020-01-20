package game.racinggame.console;

import game.InputDevice;
import game.OutputDevice;
import game.racinggame.RacingNamesDataTransferObject;

import java.util.Arrays;
import java.util.List;

import static game.constant.NumberConstant.ZERO;

public class RacingNameConsole implements InputDevice, OutputDevice {

    private static final String COMMA = ",";
    private List<String> carNames = null;
    private int tryCount = 0;

    public RacingNameConsole(){}

    @Override
    public Object doInput() {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 를 기준으로 구분)");
        final String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        final int tryCount = toInt(scanner.nextLine());

        validateCheck(tryCount);

        return new RacingNamesDataTransferObject(splitByComma(carNames), tryCount);
    }

    private int toInt(final String answer){
        return Integer.parseInt(answer);
    }

    private List<String> splitByComma(final String carNames) {
        return Arrays.asList(
                carNames.split(COMMA));
    }

    private void validateCheck(final int tryCount){

        if(tryCount <= ZERO) {
            throw new IllegalArgumentException("자동차 회수를 잘못 입력하였습니다. 다시 확인해주세요.");
        }
    }

    @Override
    public void showResult(Object object) {

    }
}
