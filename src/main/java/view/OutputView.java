package view;

public class OutputView {
    private static final String gameStartMessage = "다리 건너기 게임을 시작합니다.";
    private static final String gameEndMessage = "최종 게임 결과";
    private static final String gameStateMessage = "게임 성공 여부";
    private static final String gameTryMessage = "총 시도한 횟수";

    private static final String gameSuccess = "성공";
    private static final String gameFail = "실패";

    private static final int d = 0;

    public static void printGameStart() {
        System.out.println(gameStartMessage);
    }

    public static void printGameEndMessage() {
        System.out.println(gameEndMessage);
    }

    public static void printGameTryMessage() {
        System.out.println(gameTryMessage);
    }

    public static void printGameTry() {
        System.out.println(gameTryMessage);
    }
}