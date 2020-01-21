package game.racinggame.console;

import game.InputDevice;
import game.OutputDevice;
import game.racinggame.RacingCar;
import game.racinggame.RacingDataTransferObject;

import java.util.Arrays;
import java.util.List;

import static game.constant.NumberConstant.ZERO;

final public class RacingConsole implements InputDevice, OutputDevice {

    private static final String COMMA = ",";
    private List<String> carNames = null;
    private int tryCount = 0;

    public RacingConsole(){}

    @Override
    public Object doInput() {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 를 기준으로 구분)");
        final String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        final int tryCount = toInt(scanner.nextLine());

        final List<String> carList = splitByComma(carNames);

        validateCarsCheck(carList);
        validateInputCheck(tryCount);

        return new RacingDataTransferObject(splitByComma(carNames), tryCount);
    }

    private int toInt(final String answer){
        return Integer.parseInt(answer);
    }

    private List<String> splitByComma(final String carNames) {
        return Arrays.asList(
                carNames.split(COMMA));
    }

    private void validateInputCheck(final int tryCount){
        if(tryCount <= ZERO) {
            throw new IllegalArgumentException("자동차 회수를 잘못 입력하였습니다. 다시 확인해주세요.");
        }
    }

    private void validateCarsCheck(final List<String> carList) {
        if(carList.size() <= ZERO) {
            throw new IllegalArgumentException("경주할 자동차가 없습니다. 다시 확인해주세요.");
        }
    }

    @Override
    public void showResult(Object object) {

        // 레이싱 콘솔은 반드시 List<RacingCar> 타입을 인자로 받는다.
        @SuppressWarnings("unchecked")
        List<RacingCar> racingCars = (List<RacingCar>) object;
        printCarTraces(racingCars);
    }

    private void printCarTraces(final List<RacingCar> cars){

        final int rounds = cars.get(0).getTryCount();
        final int carCount = cars.size();

        System.out.println();
        for(int round = 0; round < rounds; round++) {
            printCarTracesByRound(cars, carCount, round);
            System.out.println();
        }
    }

    private void printCarTracesByRound(final List<RacingCar> cars, final int carCount, final int round) {

        for(int number = 0; number < carCount; number++){
            System.out.println(cars.get(number)
                    .getMyTracesByRound(round));
        }
    }
}
