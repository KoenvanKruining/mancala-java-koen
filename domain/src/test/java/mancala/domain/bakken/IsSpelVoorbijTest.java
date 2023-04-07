package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static mancala.domain.Spelmaker.maakBord;

public class IsSpelVoorbijTest {
    @Test
    public void testSpelisNietVoorbijBijBallenInDeStartput(){
        Bak[] speelbord=maakBord(2);

        Assertions.assertFalse(speelbord[0].isSpelVoorbij());
    }

    @Test
    public void testSpelisNietVoorbijBijBallenInAnderePutvanEigenaar(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[0]).doeZet();

        Assertions.assertFalse(speelbord[0].isSpelVoorbij());
    }

    @Test
    public void testSpelIsVoorbijAlsEigenaarAanDeBeurtIsEnAlZijnPuttenLeegZijn(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();
        ((Put)speelbord[1]).doeZet();


        Assertions.assertTrue(speelbord[1].isSpelVoorbij());
    }

    @Test
    public void testSpelIsNietVoorbijAlsTegenstanderAanDeBeurtEnTegenstanderNogBallenHeeft(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[0]).doeZet();
        ((Put)speelbord[3]).doeZet();
        ((Put)speelbord[0]).doeZet();
        ((Put)speelbord[4]).doeZet();
        ((Put)speelbord[3]).doeZet();
        ((Put)speelbord[0]).doeZet();
        ((Put)speelbord[4]).doeZet();

        Assertions.assertFalse(speelbord[4].isSpelVoorbij());
    }

}
