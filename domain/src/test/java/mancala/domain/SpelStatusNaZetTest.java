package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class SpelStatusNaZetTest {
    @Test
    public void SpelLooptDoorNaLegaleZet(){
        Playable spel=new MancalaSpel("Rick","Viviyan");
        spel.playPit(1);
        Assertions.assertFalse(spel.isEndOfGame());
        Assertions.assertEquals(spel.getWinner(), Playable.Winner.NO_ONE);
    }
}
