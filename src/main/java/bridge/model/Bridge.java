package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<BridgeNode> nodes;

    private Bridge(final List<String> symbols) {
        this.nodes = makeNodes(symbols);
    }

    private List<BridgeNode> makeNodes(final List<String> symbols) {
        final List<BridgeNode> bridgeNodes = new ArrayList<>();

        for (int i = 0; i < symbols.size(); i++) {
            bridgeNodes.add(BridgeNode.create(symbols.get(i), i));
        }
        return bridgeNodes;
    }

    public static Bridge withSymbols(final List<String> symbols) {
        return new Bridge(symbols);
    }

    public MoveResult move(final BridgeNode other) {
        return nodes.stream()
                .map(node -> node.compare(other))
                .filter(MoveResult::isPass)
                .findFirst()
                .orElse(MoveResult.FAIL);
    }
}
