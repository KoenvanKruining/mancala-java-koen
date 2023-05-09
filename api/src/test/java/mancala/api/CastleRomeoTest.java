package mancala.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CastleRomeoTest {
    @Test
    public void yieldTestRomeo(){
        float expectedyield=4;
        float actualyield=11;

        assertEquals(expectedyield,actualyield);
    }
}