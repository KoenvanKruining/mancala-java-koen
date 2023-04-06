package mancala.domain;

import mancala.domain.bakken.Bak;
import mancala.domain.bakken.Kalaha;
import mancala.domain.bakken.Put;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static mancala.domain.Spelmaker.maakBord;

public class IsSpelVoorbijTest {
    @Test
    public void testSpelisNietVoorbijBijBallenInDeStartput(){
        Bak[] speelbord=maakBord(2);
        Eigenaar eigenaar=new Eigenaar();
        speelbord[0]=new Put(eigenaar);
        speelbord[1]=new Put(eigenaar);
        speelbord[2]=new Kalaha(eigenaar);
        speelbord[3]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[4]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[5]=new Kalaha(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<5;i++) speelbord[i].setBuurbak(speelbord[i+1]);
        speelbord[5].setBuurbak(speelbord[0]);
        ((Put)speelbord[0]).kiesOverbuurPut(((Put)speelbord[4]));
        ((Put)speelbord[1]).kiesOverbuurPut(((Put)speelbord[3]));
        eigenaar.startput=((Put)speelbord[0]);
        eigenaar.vraagTegenstanderOp().startput=((Put)speelbord[3]);

        Assertions.assertFalse(eigenaar.isSpelVoorbij());
    }

    @Test
    public void testSpelisNietVoorbijBijBallenInAnderePutvanEigenaar(){
        Bak[] speelbord=new Bak[6];
        Eigenaar eigenaar=new Eigenaar();
        speelbord[0]=new Put(eigenaar);
        speelbord[1]=new Put(eigenaar);
        speelbord[2]=new Kalaha(eigenaar);
        speelbord[3]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[4]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[5]=new Kalaha(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<5;i++) speelbord[i].setBuurbak(speelbord[i+1]);
        speelbord[5].setBuurbak(speelbord[0]);
        ((Put)speelbord[0]).kiesOverbuurPut(((Put)speelbord[4]));
        ((Put)speelbord[1]).kiesOverbuurPut(((Put)speelbord[3]));
        eigenaar.startput=((Put)speelbord[0]);
        eigenaar.vraagTegenstanderOp().startput=((Put)speelbord[3]);

        ((Put)speelbord[0]).doeZet();

        Assertions.assertFalse(eigenaar.isSpelVoorbij());
    }

    @Test
    public void testSpelIsVoorbijAlsEigenaarAanDeBeurtIsEnAlZijnPuttenLeegZijn(){
        Bak[] speelbord=new Bak[6];
        Eigenaar eigenaar=new Eigenaar();
        speelbord[0]=new Put(eigenaar);
        speelbord[1]=new Put(eigenaar);
        speelbord[2]=new Kalaha(eigenaar);
        speelbord[3]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[4]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[5]=new Kalaha(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<5;i++) speelbord[i].setBuurbak(speelbord[i+1]);
        speelbord[5].setBuurbak(speelbord[0]);
        ((Put)speelbord[0]).kiesOverbuurPut(((Put)speelbord[4]));
        ((Put)speelbord[1]).kiesOverbuurPut(((Put)speelbord[3]));
        eigenaar.startput=((Put)speelbord[0]);
        eigenaar.vraagTegenstanderOp().startput=((Put)speelbord[3]);

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();
        ((Put)speelbord[1]).doeZet();


        Assertions.assertTrue(eigenaar.isSpelVoorbij());
    }

    @Test
    public void testSpelIsNietVoorbijAlsTegenstanderAanDeBeurtEnTegenstanderNogBallenHeeft(){
        Bak[] speelbord=new Bak[6];
        Eigenaar eigenaar=new Eigenaar();
        speelbord[0]=new Put(eigenaar);
        speelbord[1]=new Put(eigenaar);
        speelbord[2]=new Kalaha(eigenaar);
        speelbord[3]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[4]=new Put(eigenaar.vraagTegenstanderOp());
        speelbord[5]=new Kalaha(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<5;i++) speelbord[i].setBuurbak(speelbord[i+1]);
        speelbord[5].setBuurbak(speelbord[0]);
        ((Put)speelbord[0]).kiesOverbuurPut(((Put)speelbord[4]));
        ((Put)speelbord[1]).kiesOverbuurPut(((Put)speelbord[3]));
        eigenaar.startput=((Put)speelbord[0]);
        eigenaar.vraagTegenstanderOp().startput=((Put)speelbord[3]);

        ((Put)speelbord[0]).doeZet();
        ((Put)speelbord[3]).doeZet();
        ((Put)speelbord[0]).doeZet();
        ((Put)speelbord[4]).doeZet();
        ((Put)speelbord[3]).doeZet();
        ((Put)speelbord[0]).doeZet();
        ((Put)speelbord[4]).doeZet();

        Assertions.assertFalse(eigenaar.vraagTegenstanderOp().isSpelVoorbij());
    }

}
