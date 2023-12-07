package bridge.view;

import bridge.model.BridgeStructure;
import bridge.model.CrossingDirection;
import bridge.model.CrossingResult;
import bridge.model.GameResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<CrossingResult> crossingResults, List<CrossingDirection> crossingDirections) {
        String upperResult = BridgeStructure.START.getOutput();
        String downResult = BridgeStructure.START.getOutput();
        for (int i = 0; i < crossingResults.size(); i++) {
            if (upperResult.length() > 1) {
                upperResult = upperResult.replace(BridgeStructure.END.getOutput(), BridgeStructure.MIDDLE.getOutput());
                downResult = downResult.replace(BridgeStructure.END.getOutput(), BridgeStructure.MIDDLE.getOutput());

            }
            if (crossingDirections.get(i).equals(CrossingDirection.TOP)) {
                upperResult += " " + crossingResults.get(i).getOutput() + " " + BridgeStructure.END.getOutput();
                downResult += " " + CrossingResult.NOT_CROSSING.getOutput() + " " + BridgeStructure.END.getOutput();
                continue;
            }
            upperResult += " " + CrossingResult.NOT_CROSSING.getOutput() + " " + BridgeStructure.END.getOutput();
            downResult += " " + crossingResults.get(i).getOutput() + " " + BridgeStructure.END.getOutput();
        }
        System.out.println(upperResult);
        System.out.println(downResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<CrossingResult> crossingResults, List<CrossingDirection> crossingDirections) {
        System.out.println("최종 게임 결과");
        printMap(crossingResults, crossingDirections);


    }

    public void printTotalResult(GameResult result, int count) {
        System.out.printf("게임 성공 여부: %s%n", result.getOutput());
        System.out.printf("총 시도한 횟수: %d%n", count);
    }

    public void printException(String message) {
        System.out.println(message);
    }
}
