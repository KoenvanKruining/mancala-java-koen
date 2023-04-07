package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.bakken.Bak;
import mancala.domain.bakken.Put;

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
}