package mancala.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CastleBravoTest {
    @Test
    public void yieldTestBravo(){
        float expectedyield=6;
        float actualyield=15;

        assertEquals(expectedyield,actualyield);
    }
}
