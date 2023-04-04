package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static mancala.domain.Spelmaker.maakEigenaars;
import mancala.domain.bakken.*;
import mancala.domain.bakken.Put;
public class PutjePlunderenTest {
    @Test
    public void testLaatsteBalInPutVanEigenaarGaatNaarKalaha(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[12];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        putten[5]=new Kalaha(eigenaars[0]);
        for(int i=6;i<12;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<11;i++) putten[i].setBuurbak(putten[i+1]);
        for(int i=0;i<5;i++) ((Put)putten[i]).kiesOverbuurPut(((Put)putten[10-i]));

        ((Put)putten[4]).doeZet();
        ((Put)putten[6]).doeZet();
        ((Put)putten[0]).doeZet();

        Assertions.assertEquals(0,putten[4].vraagAantalBallenOp());
        Assertions.assertEquals(2,putten[5].vraagAantalBallenOp());
    }
    @Test
    public void testLaatsteBalInPutVanEigenaarPlundertOverbuurput(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[13];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        putten[5]=new Kalaha(eigenaars[0]);
        for(int i=6;i<13;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<12;i++) putten[i].setBuurbak(putten[i+1]);
        for(int i=0;i<5;i++) ((Put)putten[i]).kiesOverbuurPut(((Put)putten[10-i]));

        ((Put)putten[4]).doeZet();
        ((Put)putten[7]).doeZet();
        ((Put)putten[0]).doeZet();

        Assertions.assertEquals(0,putten[4].vraagAantalBallenOp());
        Assertions.assertEquals(0,putten[6].vraagAantalBallenOp());
        Assertions.assertEquals(7,putten[5].vraagAantalBallenOp());
    }
}
