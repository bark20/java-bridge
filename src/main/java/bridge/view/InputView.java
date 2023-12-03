package bridge.view;

import bridge.model.BridgeSize;
import bridge.model.GameCommand;
import bridge.model.MoveDirection;
import bridge.validator.NumericValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        return readWithRetry(() -> {
            System.out.println("\n다리의 길이를 입력해주세요.");
            return BridgeSize.withSize(readNumber());
        });
    }

    private static int readNumber() {
        final String strNumber = Console.readLine();
        NumericValidator.validate(strNumber);
        return Integer.parseInt(strNumber);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveDirection readMoving() {
        return readWithRetry(() -> {
            System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
            return MoveDirection.findBySymbol(Console.readLine());
        });
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        return readWithRetry(() -> {
            System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            return GameCommand.findByCode(Console.readLine());
        });
    }

    private <T> T readWithRetry(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWithRetry(supplier);
        }
    }
}
