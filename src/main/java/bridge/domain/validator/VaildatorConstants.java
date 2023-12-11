package bridge.domain.validator;

public class VaildatorConstants {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 20;

    public static final String ONLY_NUMBER = "[ERROR] 숫자만 입력해 주세요.";
    public static final String NUMBER_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String USER_MOVE = "[ERROR] U 또는 D만 입력 가능합니다.";
    public static final String GAME_COMMAND = "[ERROR] R 또는 Q만 입력 가능합니다.";
}
