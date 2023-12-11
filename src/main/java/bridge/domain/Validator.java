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
        if (!(i >= 3 || i <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
