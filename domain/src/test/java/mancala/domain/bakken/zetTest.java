package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.Eigenaar;

import static mancala.domain.Spelmaker.maakEigenaars;

public class zetTest {
    @Test
    public void testPutIsLeegNaZet(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(0,putten[0].vraagAantalBallenOp());
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4})
    public void behoudVanBallen(int putPositie){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(5,putten[putPositie].vraagAantalBallenOp());
    }

    @Test
    public void kalahaOntvangtCorrectVanEigenaar(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Kalaha(eigenaars[0]);
        putten[2]=new Put(eigenaars[0]);
        putten[3]=new Put(eigenaars[0]);
        putten[4]=new Put(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(1,putten[1].vraagAantalBallenOp());
    }

    @ParameterizedTest
    @ValueSource(ints={2,3,4})
    public void kalahaGeeftCorrectDoorVanEigenaar(int j){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Kalaha(eigenaars[0]);
        putten[2]=new Put(eigenaars[0]);
        putten[3]=new Put(eigenaars[0]);
        putten[4]=new Put(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(5,putten[j].vraagAantalBallenOp());
    }
    @Test
    public void testEigenaarWisseltBeurtNaZet(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean eigenaarHadBeurt=eigenaars[0].isEigenaarAanDeBeurt();
        putten[0].doeZet();
        boolean eigenaarHeeftBeurt=eigenaars[0].isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(eigenaarHadBeurt,eigenaarHeeftBeurt);
    }

    @Test
    public void testTegenstanderWisseltBeurtNaZet(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean tegenstanderHadBeurt=eigenaars[1].isEigenaarAanDeBeurt();
        putten[0].doeZet();
        boolean tegenstanderHeeftBeurt=eigenaars[1].isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(tegenstanderHadBeurt,tegenstanderHeeftBeurt);
    }
    @Test
    public void testEigenaarWisseltBeurtNaZetMetKalahaErtussen(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Put(eigenaars[0]);
        putten[2]=new Kalaha(eigenaars[0]);
        putten[3]=new Put(eigenaars[1]);
        putten[4]=new Put(eigenaars[1]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean eigenaarHadBeurt=eigenaars[1].isEigenaarAanDeBeurt();
        putten[0].doeZet();
        boolean eigenaarHeeftBeurt=eigenaars[1].isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(eigenaarHadBeurt,eigenaarHeeftBeurt);
    }
    @Test
    public void testTegenstanderWisseltBeurtNaZetMetKalahaErtussen(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Put(eigenaars[0]);
        putten[2]=new Kalaha(eigenaars[0]);
        putten[3]=new Put(eigenaars[1]);
        putten[4]=new Put(eigenaars[1]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean tegenstanderHadBeurt=eigenaars[0].isEigenaarAanDeBeurt();
        putten[0].doeZet();
        boolean tegenstanderHeeftBeurt=eigenaars[0].isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(tegenstanderHadBeurt,tegenstanderHeeftBeurt);
    }

    @Test
    public void testGeenBeurtwisselIndienLaatsteBalInEigenKalaha1(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Put(eigenaars[0]);
        putten[2]=new Put(eigenaars[0]);
        putten[3]=new Put(eigenaars[0]);
        putten[4]=new Kalaha(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertTrue(putten[4].eigenaar.isEigenaarAanDeBeurt());
    }

    @Test
    public void testGeenBeurtwisselIndienLaatsteBalInEigenKalaha2(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Kalaha(eigenaars[0]);
        putten[2]=new Put(eigenaars[0]);
        putten[3]=new Put(eigenaars[0]);
        putten[4]=new Kalaha(eigenaars[0]);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertNotEquals(eigenaars[0].isEigenaarAanDeBeurt(),eigenaars[1].isEigenaarAanDeBeurt());
    }

    @Test
    public void testGeenBalInKalahaVanTegenstander(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[6];
        putten[0]=new Put(eigenaars[0]);
        putten[1]=new Kalaha(eigenaars[1]);
        putten[2]=new Put(eigenaars[1]);
        putten[3]=new Put(eigenaars[1]);
        putten[4]=new Put(eigenaars[1]);
        putten[5]=new Put(eigenaars[1]);
        for(int i=0;i<5;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(0,putten[1].vraagAantalBallenOp());
    }
}
