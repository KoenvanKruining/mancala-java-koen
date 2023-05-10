package mancala.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GetPitsPerPlayerTest {
    @Test
    public void GetPitsPerPlayerGeeft7BijStandaardBord(){
        Playable spel =new MancalaSpel("Rick", "Viviyan");

        assertEquals(7,spel.getPitsPerPlayer());
    }

    @Test
    public void GetPitsPerPlayerGeeft3Bij2PuttenPerSpeler(){
        Playable spel = new MancalaSpel("Rick","Viviyan",2);

        assertEquals(3,spel.getPitsPerPlayer());
    }
}

