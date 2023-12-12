package bridge.view;

import bridge.controller.dto.MovingResult;
import bridge.controller.dto.SingleMove;
import bridge.view.console.ConsoleWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String NONE = " ";
    private static final String SINGLE_MAP_FORMAT = " | %s";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: %s";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";

    public void printStartMessage() {
        ConsoleWriter.printlnMessage("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<SingleMove> moves) {
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        for (SingleMove move : moves) {
            if (move.direction().equals("U")) {
                up.add(move.success());
                down.add(NONE);
            }
            if (move.direction().equals("D")) {
                up.add(NONE);
                down.add(move.success());
            }
        }
        ConsoleWriter.printlnMessage(generateSingleMapRow(up));
        ConsoleWriter.printlnMessage(generateSingleMapRow(down));
        ConsoleWriter.println();
    }

    public String generateSingleMapRow(List<String> map) {
        int size = map.size();
        if (size == 1) {
            return "[ " + map.get(0) + " ]";
        }
        String head = "[ " + map.get(0);
        for (int i = 1; i < size; i++) {
            head += String.format(SINGLE_MAP_FORMAT, map.get(i));
        }
        return head + " ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(MovingResult result) {
        ConsoleWriter.printlnMessage("최종 게임 결과");
        printMap(result.singleMoves());
        ConsoleWriter.printlnFormat(GAME_RESULT_MESSAGE, result.success());
        ConsoleWriter.printlnFormat(TRY_COUNT_MESSAGE, result.count());
    }
}
