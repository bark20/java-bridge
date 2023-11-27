package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("플레이어가 모두 이동한 후 게임 상태는 Finished이다.")
    @Test
    void move() {
        // given
        BridgeGame bridgeGame = BridgeGame.defaultOf(Bridge.from(List.of("U", "U", "U")));

        // when
        for (int i = 0; i < 3; i++) {
            bridgeGame.move(MovingDirection.UP);
        }

        // then
        assertThat(bridgeGame)
                .extracting("status")
                .isEqualTo(GameStatus.FINISHED);
    }

    @DisplayName("플레이어가 이동 실패 시 게임 상태는 STOPPED.")
    @Test
    void move_stopped() {
        // given
        BridgeGame bridgeGame = BridgeGame.defaultOf(Bridge.from(List.of("U", "U", "U")));

        // when
        bridgeGame.move(MovingDirection.DOWN);

        // then
        assertThat(bridgeGame)
                .extracting("status")
                .isEqualTo(GameStatus.STOPPED);
    }

}