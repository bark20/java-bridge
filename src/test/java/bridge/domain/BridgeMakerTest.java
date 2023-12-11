package bridge.domain;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @DisplayName("size길이의 랜덤 다리를 생성한다.")
    @ValueSource(ints = {3, 5, 10})
    void makeBridgeTest(int size) {
        //given
        //when
        List<String> bridge = bridgeMaker.makeBridge(size);
        //then
        assertThat(bridge.size()).isEqualTo(size);
    }
}