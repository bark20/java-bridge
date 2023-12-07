package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {1, -2, 21})
    @DisplayName("다리 길이가 3부터 20 사이의 숫자가 아닐 시 예외가 발생한다")
    void validateSize(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(" 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }


    @Test
    @DisplayName("무작위 값을 이용해 다리를 생성할 수 있다.")
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertAll(
                () -> assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3),
                () -> assertThat(bridgeMaker.makeBridge(3)).containsAnyElementsOf(List.of(CrossingDirection.TOP.getSignatureLetter(), CrossingDirection.BOTTOM.getSignatureLetter()))
        );
    }
}