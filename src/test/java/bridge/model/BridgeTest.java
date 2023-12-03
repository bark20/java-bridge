package bridge.model;

import static bridge.model.MoveDirection.DOWN;
import static bridge.model.MoveDirection.UP;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("다리를 건널 수 있다.")
    @Test
    void test_move() {
        // given
        Bridge bridge = Bridge.withSymbols(List.of("U", "D", "D"));

        // when
        MoveResult move2 = bridge.move(BridgeNode.create(DOWN, 1));
        MoveResult move3 = bridge.move(BridgeNode.create(DOWN, 2));
        MoveResult move1 = bridge.move(BridgeNode.create(UP, 0));

        // then
        Assertions.assertThat(move2).isEqualTo(MoveResult.PASS);
        Assertions.assertThat(move3).isEqualTo(MoveResult.PASS);
        Assertions.assertThat(move1).isEqualTo(MoveResult.PASS);
    }
}
