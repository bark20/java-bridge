package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Game {
    private int count;
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        count = 1;
    }

    public void start() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        play(new Bridge(attempt(() -> bridgeMaker.makeBridge(attempt(() -> inputView.readBridgeSize())))), new ArrayList<>(), new ArrayList<>());
    }

    private void play(Bridge bridge, List<CrossingResult> crossingResults, List<CrossingDirection> crossingDirections) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!bridgeGame.finish()) {
            crossingDirections.add(attempt(() -> CrossingDirection.of(attempt(() -> inputView.readMoving()))));
            crossingResults.add(bridgeGame.move(crossingDirections.get(crossingDirections.size() - 1).getSignatureLetter()));
            outputView.printMap(crossingResults, crossingDirections);
            if (crossingResults.get(crossingResults.size() - 1).equals(CrossingResult.FAIL)) {
                retry(bridge, crossingResults, crossingDirections);
                return;
            }
        }
        outputView.printResult(crossingResults, crossingDirections);
        outputView.printTotalResult(bridgeGame.win(crossingResults.get(crossingResults.size() - 1)), count);
    }

    private void retry(Bridge bridge, List<CrossingResult> crossingResults, List<CrossingDirection> crossingDirections) {
        if (attempt(() -> GameDecision.of(attempt(() -> inputView.readGameCommand())).equals(GameDecision.RETRY))) {
            count++;
            play(new Bridge(bridge), new ArrayList<>(), new ArrayList<>());
            return;
        }
        outputView.printResult(crossingResults, crossingDirections);
        outputView.printTotalResult(GameResult.FAIL, count);
    }

    private <T> T attempt(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return attempt(inputSupplier);
        }
    }
}
