package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @DisplayName("다리 사이즈는 3이상 20이하만 가능")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void sizeLimit(int size) {
        // when
        BridgeSize result = BridgeSize.from(size);

        // then
        assertThat(result.getSize()).isEqualTo(size);
    }

    @DisplayName("다리 사이즈가 3이상 20이하가 아니라면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 21})
    void sizeException(int size) {
        // when & then
        assertThatThrownBy(() -> BridgeSize.from(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

}