package bridge.view.output;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.MovePosition;
import bridge.domain.MoveRecord;
import bridge.domain.MovingDirection;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputFormatterTest {

    @DisplayName("라운드 이동 결과 출력 포맷팅")
    @Test
    void formatMoveResult() {
        // given
        List<MoveRecord> moveRecords = List.of(
                MoveRecord.successRecord(MovePosition.from(1), MovingDirection.UP),
                MoveRecord.failRecord(MovePosition.from(2), MovingDirection.UP)
        );

        // when
        String result = OutputFormatter.formatMoveResult(moveRecords);

        // then
        assertThat(result).isEqualTo(
                "[ O | X ]"
                        + System.lineSeparator()
                        + "[   |   ]"
        );
    }

}