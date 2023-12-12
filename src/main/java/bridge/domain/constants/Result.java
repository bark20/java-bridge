package bridge.domain.constants;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패");

    private final String name;

    Result(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
