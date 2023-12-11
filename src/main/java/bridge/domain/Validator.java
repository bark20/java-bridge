package bridge.domain;

public class Validator {

    public void validateBridgeSize(String userInput) {
        validateOnlyNumber(userInput);

    }

    private void validateOnlyNumber(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }
}
