package bridge;

import bridge.controller.BridgeController;

public class Application {
    private static final BridgeController controller = new BridgeController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.process();
    }
}
