package bridge;

import bridge.controller.Game;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        new Game(new InputView(), new OutputView()).start();
    }
}
