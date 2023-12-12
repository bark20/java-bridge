package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.constant.MoveCommand;
import bridge.domain.constant.Status;
import bridge.domain.model.GameDashboard;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameDashboardTest {

    @Test
    @DisplayName("이동할 칸 체크 메소드 테스트")
    void updateResult() {
        GameDashboard gameDashboard = new GameDashboard();
        gameDashboard.updateResult(Status.SUCCESS, MoveCommand.UP);
        gameDashboard.updateResult(Status.FAIL, MoveCommand.DOWN);

        assertThat(gameDashboard.getUpResult())
                .isEqualTo(Arrays.asList(Status.SUCCESS, Status.SPACE));
        assertThat(gameDashboard.getDownResult())
                .isEqualTo(Arrays.asList(Status.SPACE, Status.FAIL));
    }
}