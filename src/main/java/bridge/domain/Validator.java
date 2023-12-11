package bridge.domain;

public class Validator {

    public void validateBridgeSize(String userInput) {
        validateOnlyNumber(userInput);
        validateNumberRange(Integer.parseInt(userInput));
    }

    private void validateOnlyNumber(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }

    private void validateNumberRange(int i) {
        if (!(i >= 3 && i <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateUserMove(String userInput) {
        if (!(userInput.equals("U") || userInput.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력 가능합니다.");
        }
    }

    public void validateGameCommand(String userInput) {
        if (!(userInput.equals("R") || userInput.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력 가능합니다.");
        }
    }
}
