package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import bridge.util.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BridgeMakerTest {

    @Mock
    private BridgeNumberGenerator bridgeNumberGenerator;

    @InjectMocks
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makeBridgeTestWithUp() {
        when(bridgeNumberGenerator.generate()).thenReturn(1);

        List<String> result = bridgeMaker.makeBridge(5);

        assertEquals(5, result.size());
        assertEquals("U", result.get(0));
    }

    @Test
    void makeBridgeTestWithDown() {
        when(bridgeNumberGenerator.generate()).thenReturn(0);

        List<String> result = bridgeMaker.makeBridge(5);

        assertEquals(5, result.size());
        assertEquals("D", result.get(0));
    }
}
