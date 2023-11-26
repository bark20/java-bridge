package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInputMessage() {
        printNewLine();
        println("다리의 길이를 입력해주세요.");
    }

    public void printMoveInputMessage() {
        printNewLine();
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(MoveResult moveResult) {
        println(moveResult.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printNewLine();
        println("최종 게임 결과");
        printMap(bridgeGame.getMoveResult());
        printNewLine();
        System.out.printf("게임 성공 여부: %s\n", bridgeGame.getGameResult());
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getRetryCount());
    }

    public void printRetryMessage() {
        printNewLine();
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    private void println(String output) {
        System.out.println(output);
    }

    private void printNewLine() {
        System.out.println();
    }
}
