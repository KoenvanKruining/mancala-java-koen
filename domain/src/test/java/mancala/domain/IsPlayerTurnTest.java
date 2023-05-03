package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class IsPlayerTurnTest {

    @Test
    public void speler1StartHetSpel1(){
        Playable spel =new MancalaSpel("Rick","Viviyan");
        Assertions.assertTrue(spel.isPlayersTurn("Rick"));
        Assertions.assertFalse(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }

    @Test
    public void speler1StartHetSpel2(){
        Playable spel =new MancalaSpel("Rick","Viviyan",2,4);
        Assertions.assertTrue(spel.isPlayersTurn("Rick"));
        Assertions.assertFalse(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }
    @Test
    public void beurtWisseltNaZet1(){
        Playable spel =new MancalaSpel("Rick","Viviyan");
        spel.playPit(0);
        Assertions.assertFalse(spel.isPlayersTurn("Rick"));
        Assertions.assertTrue(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }

    @Test
    public void beurtWisseltNaZet2(){
        Playable spel =new MancalaSpel("Rick","Viviyan",2,4);
        spel.playPit(0);
        Assertions.assertFalse(spel.isPlayersTurn("Rick"));
        Assertions.assertTrue(spel.isPlayersTurn("Viviyan"));
        Assertions.assertFalse(spel.isPlayersTurn("Neil"));
    }

    @Test
    public void beurtWisseltNietAlsZetEindigtInKalaha(){
        Playable spel =new MancalaSpel("Rick","Viviyan",2,2);
        spel.playPit(0);
        Assertions.assertTrue(spel.isPlayersTurn("Rick"));
        Assertions.assertFalse(spel.isPlayersTurn("Viviyan"));
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
