package bridge.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.constant.MoveCommand;
import bridge.domain.constant.Status;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        this.bridgeGame = new BridgeGame();
    }

    @Test
    @DisplayName("재시작인지 확인하는 메소드 테스트")
    void retry() {
        assertThat(bridgeGame.retry(Status.SUCCESS)).isFalse();
        assertThat(bridgeGame.retry(Status.FAIL)).isTrue();
    }

    @Test
    void move() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        MoveCommand moveCommand = MoveCommand.UP;
        Status status = Status.SUCCESS;

        if (!bridge.get(0).equals(moveCommand.getCommand())) {
            status = Status.FAIL;
        }
        bridgeGame.getGameDashboard().updateResult(status, moveCommand);
        GameDashboard gameDashboard = bridgeGame.getGameDashboard();

        assertThat(status).isEqualTo(Status.SUCCESS);
        assertThat(gameDashboard.getUpResult().get(0)).isEqualTo(Status.SUCCESS);
        assertThat(gameDashboard.getDownResult().get(0)).isEqualTo(Status.SPACE);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}