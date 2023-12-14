package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeBoard {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public void drawUpMovement(boolean isSuccess) {
        String marker = "X";
        if (isSuccess) {
            marker = "O";
        }
        upBridge.add(marker);
        downBridge.add(" ");
    }

    public void drawDownMovement(boolean isSuccess) {
        String marker = "X";
        if (isSuccess) {
            marker = "O";
        }
        upBridge.add(" ");
        downBridge.add(marker);
    }

    public int getSize() {
        return upBridge.size();
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
