package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameDecisionTest {

    @Test
    @DisplayName("전달된 문자에 해당하는 게임 진 의사가 없을 경우 예외가 발생한다")
    void failOf(){
        assertThatThrownBy(() -> BridgeGameDecision.of("T"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주어진 문자에 해당하는 게임 진행 의사가 없습니다.");
    }

    @Test
    @DisplayName("특정 문자열이 재시작을 의미하는지, 종료를 의미하는지 알 수 있다.")
    void of(){
        assertAll(
                () -> assertThat(BridgeGameDecision.of("R")).isEqualTo(BridgeGameDecision.RETRY),
                () -> assertThat(BridgeGameDecision.of("Q")).isEqualTo(BridgeGameDecision.QUIT)
        );
    }

}