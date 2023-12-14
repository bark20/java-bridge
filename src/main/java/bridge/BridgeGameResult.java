package bridge;

public class BridgeGameResult {

    public BridgeBoard bridgeBoard;
    public boolean isSuccess;

    public BridgeGameResult(BridgeBoard bridgeBoard, boolean isSuccess) {
        this.bridgeBoard = bridgeBoard;
        this.isSuccess = isSuccess;
    }

    public BridgeBoard getBridgeBoard() {
        return bridgeBoard;
    }
}
