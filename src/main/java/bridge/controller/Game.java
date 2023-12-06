package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int LAST_INDEX = -1;
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        play(new BridgeGame(bridge), new ArrayList<>(), new ArrayList<>());
    }

    private void play(BridgeGame bridgeGame, List<Crossing> bridgeCrossing, List<BridgeUnit> bridgeUnits){
        while(!bridgeGame.finish()){
            bridgeUnits.add(BridgeUnit.of(inputView.readMoving()));
            bridgeCrossing.add(bridgeGame.move(bridgeUnits.get(LAST_INDEX).getSignatureLetter()));
            outputView.printMap(bridgeCrossing, bridgeUnits);
            if(bridgeCrossing.get(LAST_INDEX).equals(Crossing.FAIL)){
                retry(bridgeGame, bridgeCrossing);
                break;
            }
        }
        outputView.printResult();
    }

    private void retry(BridgeGame bridgeGame,List<Crossing> bridgeCrossing){
        if(BridgeGameDecision.of(inputView.readGameCommand()).equals(BridgeGameDecision.RETRY)){
            play(bridgeGame, new ArrayList<>(), new ArrayList<>());
        }
    }
}
