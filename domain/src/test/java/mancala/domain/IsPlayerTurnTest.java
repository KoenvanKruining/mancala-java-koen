package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class IsPlayerTurnTest {
    @Test
    public void speler1StartHetSpel(){
        Playable spel =new MancalaSpel("Rick","Viviyan");
        Assertions.assertTrue(spel.isPlayersTurn("Rick"));
        Assertions.assertFalse(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }

    @Test
    public void beurtWisseltNaZet(){
        Playable spel =new MancalaSpel("Rick","Viviyan");
        spel.playPit(1);
        Assertions.assertFalse(spel.isPlayersTurn("Rick"));
        Assertions.assertTrue(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }

    @Test
    public void beurtWisseltNietNaIllegaleZet(){
        Playable spel =new MancalaSpel("Rick","Viviyan");
        spel.playPit(7);
        Assertions.assertTrue(spel.isPlayersTurn("Rick"));
        Assertions.assertFalse(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }
}
