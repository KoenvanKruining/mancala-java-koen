package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.bakken.Bak;
import mancala.domain.bakken.Put;
import static mancala.domain.Playable.Winner.*;

import static mancala.domain.Spelmaker.maakBord;

public class SpelEindeTest {
    @Test
    public void testSpelEindigtInKalaha(){
        Bak[] spelbord=maakBord(1);

        ((Put)spelbord[0]).doeZet();
        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(0,spelbord[0].vraagAantalBallenOp());
        Assertions.assertEquals(3,spelbord[1].vraagAantalBallenOp());
        Assertions.assertEquals(0,spelbord[2].vraagAantalBallenOp());
        Assertions.assertEquals(5,spelbord[3].vraagAantalBallenOp());
    }

    @Test
    public void testSpelStoptEnBepaaltWinnaar1(){
        Playable spel= new MancalaSpel("Rick", "Viviyan",1);
        spel.playPit(0);
        spel.playPit(0);

        Assertions.assertTrue(spel.isEndOfGame());
        Assertions.assertEquals(PLAYER_2,spel.getWinner());
    }

    @Test
    public void testSpelStoptEnBepaaltWinnaar2(){
        Playable spel= new MancalaSpel("Rick", "Viviyan",2,1);
        spel.playPit(0);
        spel.playPit(4);
        spel.playPit(3);
        spel.playPit(1);
        spel.playPit(4);
        spel.playPit(3);

        Assertions.assertTrue(spel.isEndOfGame());
        Assertions.assertEquals(PLAYER_2,spel.getWinner());
    }
    @Test
    public void testSpelStoptEnBepaaltGelijkspel(){
        Playable spel= new MancalaSpel("Rick", "Viviyan",1,1);
        spel.playPit(0);

        Assertions.assertTrue(spel.isEndOfGame());
        Assertions.assertEquals(DRAW,spel.getWinner());
    }

    @Test
    public void testSpelStoptEnBepaaltGelijkspel2(){
        Playable spel= new MancalaSpel("Rick", "Viviyan",2,2);
        spel.playPit(0);
        spel.playPit(1);
        spel.playPit(3);
        spel.playPit(0);
        spel.playPit(4);
        spel.playPit(0);

        Assertions.assertTrue(spel.isEndOfGame());
        Assertions.assertEquals(DRAW,spel.getWinner());
    }
}
