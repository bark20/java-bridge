package bridge.view.output;

import bridge.common.utils.formatter.ErrorMessageFormatter;
import bridge.domain.BridgeGame;
import bridge.domain.MoveRecord;
import bridge.view.print.Printer;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String WELCOME_MESSAGE = "다리 건너기 게임을 시작합니다.";

    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void welcomePlayer() {
        printer.printLine(WELCOME_MESSAGE);
    }

    public void showErrorMessage(String message) {
        printer.printLine(ErrorMessageFormatter.addErrorPrefix(message));
    }

    public void showMoveResult(List<MoveRecord> moveResults) {
        printer.printLine(OutputFormatter.formatMoveResult(moveResults));
    }

    public void showTotalResult(BridgeGame bridgeGame) {
        printer.printWithEmptyLineAhead(OutputFormatter.formatTotalResult(bridgeGame.getMoveResults()));
        printer.printWithEmptyLineAhead(OutputFormatter.formatSuccessFail(bridgeGame));
        printer.printLine(OutputFormatter.formatTotalAttemptCount(bridgeGame.getAttemptCount()));
    }

}
