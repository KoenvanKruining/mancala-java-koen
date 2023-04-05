package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import mancala.domain.Eigenaar;

public class BepaalWinnaarTest {
    @Test
    public void BepaalWinnaarGeeftVerliezer(){
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

        Assertions.assertEquals(Kalaha.speluitkomst.VERLOREN,((Kalaha)speelbord[2]).bepaalWinnaar());
    }

    @Test
    public void BepaalWinnaarGeeftGelijkspel(){
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

        speelbord[0].allesNaarKalaha();

        Assertions.assertEquals(Kalaha.speluitkomst.GELIJK,((Kalaha)speelbord[2]).bepaalWinnaar());
    }

    @Test
    public void BepaalWinnaarGeeftWinnaar(){
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

        ((Put)speelbord[1]).doeZet();
        ((Put)speelbord[4]).doeZet();
        ((Put)speelbord[1]).doeZet();



        Assertions.assertEquals(Kalaha.speluitkomst.GEWONNEN,((Kalaha)speelbord[5]).bepaalWinnaar());
    }
}
