package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import mancala.domain.Eigenaar;

import static mancala.domain.Spelmaker.maakBord;

public class BepaalWinnaarTest {
    @Test
    public void BepaalWinnaarGeeftVerliezer(){
        Bak[] speelbord=maakBord(2);

        Assertions.assertEquals(Kalaha.uitkomst.VERLOREN,speelbord[2].bepaalWinnaar());
    }

    @Test
    public void BepaalWinnaarGeeftGelijkspel(){
        Bak[] speelbord=maakBord(2);

        speelbord[0].allesNaarKalaha();

        Assertions.assertEquals(Kalaha.uitkomst.GELIJK,speelbord[2].bepaalWinnaar());
    }


    @Test
    public void BepaalWinnaarGeeftWinnaar(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();
        speelbord[3].allesNaarKalaha();

        Assertions.assertEquals(Kalaha.uitkomst.GEWONNEN,speelbord[5].bepaalWinnaar());
    }
    @Test
    public void BepaalWinnaarGeeftCorrectDoor(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();
        speelbord[3].allesNaarKalaha();

        Assertions.assertEquals(Kalaha.uitkomst.VERLOREN,speelbord[1].bepaalWinnaar());
    }

    @Test
    public void BepaalWinnaarBeeindigtSpel() {
        Bak[] speelbord = maakBord(2);

        speelbord[2].bepaalWinnaar();

        Assertions.assertFalse(speelbord[2].eigenaar.isEigenaarAanDeBeurt());
        Assertions.assertFalse(speelbord[5].eigenaar.isEigenaarAanDeBeurt());
    }
}
