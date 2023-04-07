package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.Eigenaar;


public class ZetTest {
    @Test
    public void testPutIsLeegNaZet(){
        Eigenaar eigenaar=new Eigenaar();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(0,putten[0].vraagAantalBallenOp());
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4})
    public void behoudVanBallen(int putPositie){
        Eigenaar eigenaar=new Eigenaar();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(5,putten[putPositie].vraagAantalBallenOp());
    }

    @Test
    public void kalahaHoudtEenBalVastAlsEigenaarAanZet(){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaar);
        putten[1]=new Kalaha(eigenaar);
        putten[2]=new Put(eigenaar);
        putten[3]=new Put(eigenaar);
        putten[4]=new Put(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        ((Put)putten[0]).doeZet();

        Assertions.assertEquals(1,putten[1].vraagAantalBallenOp());
    }

    @ParameterizedTest
    @ValueSource(ints={2,3,4})
    public void kalahaGeeftAllesMinEenAlsVanEigenaarAanZet(int j){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaar);
        putten[1]=new Kalaha(eigenaar);
        putten[2]=new Put(eigenaar);
        putten[3]=new Put(eigenaar);
        putten[4]=new Put(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        ((Put)putten[0]).doeZet();

        Assertions.assertEquals(5,putten[j].vraagAantalBallenOp());
    }
    @Test
    public void testEigenaarWisseltBeurtNaZet(){
        Eigenaar eigenaar=new Eigenaar();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean eigenaarHadBeurt=eigenaar.isEigenaarAanDeBeurt();
        putten[0].doeZet();
        boolean eigenaarHeeftBeurt=eigenaar.isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(eigenaarHadBeurt,eigenaarHeeftBeurt);
    }

    @Test
    public void testTegenstanderWisseltBeurtNaZet(){
        Eigenaar eigenaar=new Eigenaar();
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean tegenstanderHadBeurt=eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();
        putten[0].doeZet();
        boolean tegenstanderHeeftBeurt=eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(tegenstanderHadBeurt,tegenstanderHeeftBeurt);
    }
    @Test
    public void testEigenaarWisseltBeurtNaZetMetKalahaErtussen(){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Kalaha(eigenaar);
        putten[3]=new Put(eigenaar.vraagTegenstanderOp());
        putten[4]=new Put(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean eigenaarHadBeurt=eigenaar.isEigenaarAanDeBeurt();
        ((Put)putten[0]).doeZet();
        boolean eigenaarHeeftBeurt=eigenaar.isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(eigenaarHadBeurt,eigenaarHeeftBeurt);
    }
    @Test
    public void testTegenstanderWisseltBeurtNaZetMetKalahaErtussen(){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Kalaha(eigenaar);
        putten[3]=new Put(eigenaar.vraagTegenstanderOp());
        putten[4]=new Put(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        boolean tegenstanderHadBeurt=eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();
        ((Put)putten[0]).doeZet();
        boolean tegenstanderHeeftBeurt=eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(tegenstanderHadBeurt,tegenstanderHeeftBeurt);
    }

    @Test
    public void testGeenBeurtwisselIndienLaatsteBalInEigenKalaha1(){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Put(eigenaar);
        putten[3]=new Put(eigenaar);
        putten[4]=new Kalaha(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        ((Put)putten[0]).doeZet();

        Assertions.assertTrue(putten[4].eigenaar.isEigenaarAanDeBeurt());
    }

    @Test
    public void testGeenBeurtwisselIndienLaatsteBalInEigenKalaha2(){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[5];
        putten[0]=new Put(eigenaar);
        putten[1]=new Kalaha(eigenaar);
        putten[2]=new Put(eigenaar);
        putten[3]=new Put(eigenaar);
        putten[4]=new Kalaha(eigenaar);
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        ((Put)putten[0]).doeZet();

        Assertions.assertNotEquals(eigenaar.isEigenaarAanDeBeurt(),eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt());
    }

    @Test
    public void testGeenBalInKalahaVanTegenstander(){
        Eigenaar eigenaar=new Eigenaar();
        Bak[] putten=new Bak[6];
        putten[0]=new Put(eigenaar);
        putten[1]=new Kalaha(eigenaar.vraagTegenstanderOp());
        putten[2]=new Put(eigenaar.vraagTegenstanderOp());
        putten[3]=new Put(eigenaar.vraagTegenstanderOp());
        putten[4]=new Put(eigenaar.vraagTegenstanderOp());
        putten[5]=new Put(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<5;i++) putten[i].buurBak=putten[i+1];

        ((Put)putten[0]).doeZet();

        Assertions.assertEquals(0,putten[1].vraagAantalBallenOp());
    }
}
