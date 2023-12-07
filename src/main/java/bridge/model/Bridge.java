package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> unit;
    private int index;

    public Bridge(List<String> unit) {
        this.unit = new ArrayList<>(unit);
        this.index = 0;
    }

    public Bridge(Bridge bridge) {
        this.unit = new ArrayList<>(bridge.unit);
        this.index = 0;
    }

    public boolean cross(String bridgeUnitLetter) {
        return !end() && unit.get(index++).equals(bridgeUnitLetter);
    }

    public boolean end() {
        return unit.size() == index;
    }
}
