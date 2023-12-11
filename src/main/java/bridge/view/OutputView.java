package bridge.view;

public class OutputView {

    public void printMap(String moveResult) {
        System.out.println(moveResult);
    }

    public void printResult(String finalMoveResult, boolean isSuccess, int gameCount) {
        System.out.println(ViewConstants.FINAL_RESULT_MESSAGE);
        System.out.println(finalMoveResult);

        String crossSuccess = getIsSuccess(isSuccess);
        System.out.println(String.format(ViewConstants.CROSS_SUCCESS_FORMAT, crossSuccess));
        System.out.println(String.format(ViewConstants.GAME_COUNT_FORMAT, gameCount));
    }

    public void gameStartMessage() {
        System.out.println(ViewConstants.START_MESSAGE);
    }

    public void inputBridgeSizeMessage() {
        System.out.println(ViewConstants.INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMoveMessage() {
        System.out.println(ViewConstants.INPUT_MOVE_MESSAGE);
    }

    public void printInputRetryGameMessage() {
        System.out.println(ViewConstants.INPUT_RETRY_GAME_MESSAGE);
    }

    private static String getIsSuccess(boolean isSuccess) {
        if (isSuccess) {
            return ViewConstants.SUCCESS;
        }
        return ViewConstants.FAIL;
    }
}
