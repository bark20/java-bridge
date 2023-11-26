package bridge;

import bridge.controller.GameController;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import bridge.view.print.ConsolePrinter;
import bridge.view.print.Printer;

public class Application {

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        InputView inputView = new InputView(printer);
        OutputView outputView = new OutputView(printer);

        GameController gameController = new GameController(inputView, outputView);
        gameController.run();
    }

}
