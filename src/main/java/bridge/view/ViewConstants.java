package bridge.view;

public class ViewConstants {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_SIZE_MESSAGE = LINE_SEPARATOR + "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVE_MESSAGE = LINE_SEPARATOR + "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_GAME_MESSAGE =
            LINE_SEPARATOR + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_RESULT_MESSAGE = LINE_SEPARATOR + "최종 게임 결과";
    public static final String CROSS_SUCCESS_FORMAT = LINE_SEPARATOR + "게임 성공 여부: %s";
    public static final String GAME_COUNT_FORMAT = "총 시도한 횟수: %d";

}
