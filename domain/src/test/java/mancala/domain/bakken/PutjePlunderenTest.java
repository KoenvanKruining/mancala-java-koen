package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static mancala.domain.Spelmaker.maakBord;

public class PutjePlunderenTest {
    @Test
    public void testLaatsteBalInPutVanEigenaarGaatNaarKalaha(){
        Bak[] putten=maakBord();

        ((Put)putten[5]).doeZet();
        ((Put)putten[7]).doeZet();
        ((Put)putten[1]).doeZet();

        Assertions.assertEquals(0,putten[5].vraagAantalBallenOp());
        Assertions.assertEquals(2,putten[6].vraagAantalBallenOp());
    }
    @Test
    public void testLaatsteBalInPutVanEigenaarPlundertOverbuurput(){
        Bak[] putten=maakBord();

        ((Put)putten[4]).doeZet();
        ((Put)putten[7]).doeZet();
        ((Put)putten[0]).doeZet();

        Assertions.assertEquals(0,putten[4].vraagAantalBallenOp());
        Assertions.assertEquals(0,putten[8].vraagAantalBallenOp());
        Assertions.assertEquals(8,putten[6].vraagAantalBallenOp());
    }

    @Test
    public void testPutjeplunderenIndienLaatstePutStartPutIs(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();

        Assertions.assertEquals(0,speelbord[0].vraagAantalBallenOp());
        Assertions.assertEquals(0,speelbord[4].vraagAantalBallenOp());
    }
}
