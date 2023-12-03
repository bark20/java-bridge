package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.BridgeType;
import bridge.model.GameResult;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printBridgeGameTitle() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final GameResult gameResult) {
        StringBuilder message = new StringBuilder();
        message.append(formatBridgeOf(gameResult, BridgeType.LEFT));
        message.append(System.lineSeparator());
        message.append(formatBridgeOf(gameResult, BridgeType.RIGHT));
        System.out.println(message);
    }

    private String formatBridgeOf(final GameResult gameResult, final BridgeType type) {
        final List<String> moveResults = gameResult.getResultOf(type);
        final StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");

        for (final String moveResult : moveResults) {
            sj.add(moveResult);
        }
        return sj.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final BridgeGame game) {
        System.out.println("\n최종 게임 결과");
        printMap(game.getResult());
        System.out.println("게임 성공 여부: " + formatGameStatus(game));
        System.out.println("총 시도한 횟수: " + game.tryCount());
    }

    private static String formatGameStatus(final BridgeGame game) {
        if (game.isClear()) {
            return "성공";
        }
        return "실패";
    }
}
