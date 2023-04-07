package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.bakken.Bak;
import mancala.domain.bakken.Put;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints={0,1,3,4})
    public void testSpelEindigtInPut1(int i){
        Bak[] spelbord=maakBord(2);

        ((Put)spelbord[0]).doeZet();
        ((Put)spelbord[3]).doeZet();
        ((Put)spelbord[0]).doeZet();
        ((Put)spelbord[4]).doeZet();
        ((Put)spelbord[4]).doeZet();
        ((Put)spelbord[3]).doeZet();
        ((Put)spelbord[1]).doeZet();
        ((Put)spelbord[3]).doeZet();
        ((Put)spelbord[0]).doeZet();
        ((Put)spelbord[4]).doeZet();
        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(0,spelbord[i].vraagAantalBallenOp());
    }
}
