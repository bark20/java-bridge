package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @ParameterizedTest
    @DisplayName("isMoved 변수가 유저의 입력에 따라 맞으면 true 틀리면 false")
    @CsvSource(value = {"U, true", "D, false"})
    void moveTest(String userMove, boolean expect) {
        //given

        //when
        bridgeGame.move(userMove);
        //then
        assertThat(bridgeGame).extracting("isMoved").isEqualTo(expect);

    }

    @Test
    @DisplayName("quit() 메소드 사용시 isRetry 변수가 false가 된다.")
    void quitTest() {
        //given
        //when
        bridgeGame.quit();
        //then
        assertThat(bridgeGame.retry()).isFalse();
    }

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D"));
    }

    @Test
    @DisplayName("메소드 사용시 userPosition이 1씩 증가한다.")
    void userMovedTest() {
        //given
        //when
        bridgeGame.userMoved();
        bridgeGame.userMoved();
        //then
        assertThat(bridgeGame).extracting("userPosition").isEqualTo(2);
    }

    @Test
    @DisplayName("메소드 사용시 userPosition 변수가 0으로 초기화된다.")
    void resetUserPositionTest() {
        //given
        bridgeGame.userMoved();
        //when
        bridgeGame.resetUserPosition();
        //then
        assertThat(bridgeGame).extracting("userPosition").isEqualTo(0);
    }

    @Test
    @DisplayName("메소드 사용시 userPosition 변수를 반환한다.")
    void getUserPositionTest() {
        //given
        bridgeGame.userMoved();
        bridgeGame.userMoved();
        //when, then
        assertThat(bridgeGame.getUserPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("position위치의 다리 정답을 반환한다.")
    @CsvSource(value = {"0, U", "1, D", "2, D"})
    void nextCorrectBridgeTest(int position, String expect) {
        //given
        //when, then
        assertThat(bridgeGame.nextCorrectBridge(position)).isEqualTo(expect);
    }

}
