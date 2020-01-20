package game.racinggame.console;

import game.InputDevice;
import game.OutputDevice;
import game.racinggame.RacingDataTransferObject;

import java.util.List;

import static game.constant.NumberConstant.ZERO;

final public class RacingConsole implements InputDevice, OutputDevice {

    private int carNumber = 0;
    private int tryCount = 0;

    public RacingConsole(){}

    @Override
    public Object doInput() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        final int carNumber = toInt(scanner.nextLine());

        System.out.println("시도할 회수는 몃 회 인가요?");
        final int tryCount = toInt(scanner.nextLine());

        validateCheck(carNumber, tryCount);

        return new RacingDataTransferObject(carNumber, tryCount);
    }

    private int toInt(final String answer){
        return Integer.parseInt(answer);
    }

    private void validateCheck(final int carNumber, final int tryCount) {
        if(carNumber <= ZERO || tryCount <= ZERO){
            throw new IllegalArgumentException("자동차 대수와 시도할 회수를 잘못 입력하였습니다. 다시 확인해주세요.");
        }
    }

    @Override
    public void showResult(Object object) {

        // 레이싱 콘솔은 반드시 List<List<String>> 타입을 인자로 받는다.
        @SuppressWarnings("unchecked")
        List<List<String>> tracesList = (List<List<String>>) object;

        this.carNumber = tracesList.size();
        this.tryCount = tracesList.get(0).size();

        int round = 1;

        while(round < tryCount) {
            printCarTraces(tracesList, round);
            ++round;
        }
    }

    private void printCarTraces(final List<List<String>> traces, final int round){

        for(int number = 0; number < carNumber; number++){
            System.out.println(traces.get(number).get(round));
        }

        System.out.println();
    }
}
