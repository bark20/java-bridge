package view;

import bridge.BridgeBoard;
import bridge.BridgeGameResult;
import utils.Parser;

import java.util.*;

public class OutputView {
    private static final String gameStartMessage = "다리 건너기 게임을 시작합니다.";
    private static final String gameEndMessage = "최종 게임 결과";
    private static final String gameStateMessage = "게임 성공 여부";
    private static final String gameTryMessage = "총 시도한 횟수";

    private static final String gameSuccess = "성공";
    private static final String gameFail = "실패";
    private static String bridgeFormat = "[ %s ]";

    private static final int d = 0;

    public static void printGameStart() {
        System.out.println(gameStartMessage);
    }

    public static void printGameEndMessage() {
        System.out.println(gameEndMessage);
    }

    public static void printGameStateMessage(boolean gameState) {
        if (gameState) {
            System.out.println(gameStateMessage + ": " + gameSuccess);
            return;
        }
        System.out.println(gameStateMessage + ": " + gameFail);
    }

    public static void printGameTryMessage(int number) {
        System.out.println(gameTryMessage + ": " + number);
    }

    public static void printMap(BridgeBoard bridgeBoard) {
        System.out.println(String.format(bridgeFormat, Parser.joinWithBlank(bridgeBoard.getUpBridge())));
        System.out.println(String.format(bridgeFormat, Parser.joinWithBlank(bridgeBoard.getDownBridge())));
    }

    public static void printResult(BridgeBoard bridgeBoard) {
        OutputView.printGameEndMessage();
        OutputView.printMap(bridgeBoard);
        System.out.println();
    }

    public static void printGameResultMessage(BridgeGameResult bridgeGameResult, int tryCount) {
        OutputView.printGameEndMessage();
        OutputView.printResult(bridgeGameResult.getBridgeBoard());
        OutputView.printGameStateMessage(bridgeGameResult.isSuccess);
        OutputView.printGameTryMessage(tryCount);
    }
}