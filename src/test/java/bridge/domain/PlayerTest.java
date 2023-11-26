package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("방향에 따라 이동할 수 있다.")
    @Test
    void moveSuccess() {
        // given
        Player player = Player.defaultOf();

        // when
        player.move(MovingDirection.UP, Bridge.from(List.of("U", "U", "U")));

        // then
        assertThat(player.getCurrentPosition()).isEqualTo(2);

        List<MoveRecord> records = player.getRecords();
        assertThat(records.get(0))
                .extracting("position", "direction", "moveResult")
                .containsExactly(1, MovingDirection.UP, MoveResult.SUCCESS);
    }

    @DisplayName("방향에 따라 이동할 수 있다.")
    @Test
    void moveFail() {
        // given
        Player player = Player.defaultOf();

        // when
        player.move(MovingDirection.DOWN, Bridge.from(List.of("U", "U", "U")));

        // then
        assertThat(player.getCurrentPosition()).isEqualTo(2);

        List<MoveRecord> records = player.getRecords();
        assertThat(records.get(0))
                .extracting("position", "direction", "moveResult")
                .containsExactly(1, MovingDirection.DOWN, MoveResult.FAIL);
    }

    @DisplayName("방향에 따라 이동 - 여러번 이동.")
    @Test
    void moveTwice() {
        // given
        Player player = Player.defaultOf();
        Bridge bridge = Bridge.from(List.of("U", "U", "U"));

        // when
        player.move(MovingDirection.DOWN, bridge);
        player.move(MovingDirection.UP, bridge);

        // then
        assertThat(player.getCurrentPosition()).isEqualTo(3);

        List<MoveRecord> records = player.getRecords();
        assertThat(records.get(0))
                .extracting("position", "direction", "moveResult")
                .containsExactly(1, MovingDirection.DOWN, MoveResult.FAIL);

        assertThat(records.get(1))
                .extracting("position", "direction", "moveResult")
                .containsExactly(2, MovingDirection.UP, MoveResult.SUCCESS);
    }

}