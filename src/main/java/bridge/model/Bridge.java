package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> units;

    public Bridge(List<String> units) {
        this.units = new ArrayList<>(units);
    }

    public boolean cross(String bridgeUnitLetter){
        if(units.get(0).equals(bridgeUnitLetter)){
            units.remove(0);
            return true;
        }
        return false;
    }

    public boolean end(){
        return units.size() == 0;
    }
}
