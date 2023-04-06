package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;

import static mancala.domain.Spelmaker.maakBord;

public class EindeCheckerTest {
    @Test
    public void testKalahaGeeftTrueTerug(){
        Eigenaar eigenaar=new Eigenaar();
        Kalaha kalaha=new Kalaha(eigenaar);

        Assertions.assertTrue(kalaha.eindeChecker());
    }

    @Test
    public void testGevuldePutGeeftFalseTerug(){
        Eigenaar eigenaar=new Eigenaar();
        Put put=new Put(eigenaar);

        Assertions.assertFalse(put.eindeChecker());
    }

    @Test
    public void testLegePutGeeftStatusVanLegeBuurputDoor(){
        Bak[] speelbord=maakBord(2);

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();
        ((Put)speelbord[1]).doeZet();

        Assertions.assertTrue(speelbord[0].eindeChecker());
    }

    @Test
    public void testLegePutGeeftStatusVanGevuldeBuurputDoor(){
        Bak[] speelbord=new Bak[5];
        Eigenaar eigenaar=new Eigenaar();
        speelbord[0]=new Put(eigenaar);
        speelbord[1]=new Put(eigenaar);
        speelbord[2]=new Kalaha(eigenaar);
        speelbord[3]=new Put(eigenaar);
        speelbord[4]=new Put(eigenaar);
        for(int i=0;i<4;i++) speelbord[i].setBuurbak(speelbord[i+1]);

        ((Put)speelbord[0]).doeZet();

        Assertions.assertFalse(speelbord[0].eindeChecker());
    }
}
