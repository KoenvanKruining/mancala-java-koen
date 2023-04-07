package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.Eigenaar;

import static mancala.domain.Spelmaker.maakBord;


public class ZetTest {
    @Test
    public void testPutIsLeegNaZet(){
        Bak[] spelbord=maakBord();

        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(0,spelbord[0].vraagAantalBallenOp());
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4})
    public void behoudVanBallen(int putPositie){
        Bak[] spelbord=maakBord();

        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(5,spelbord[putPositie].vraagAantalBallenOp());
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
        Bak[] spelbord=maakBord();

        boolean eigenaarHadBeurt=spelbord[0].eigenaar.isEigenaarAanDeBeurt();
        ((Put)spelbord[0]).doeZet();
        boolean eigenaarHeeftBeurt=spelbord[0].eigenaar.isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(eigenaarHadBeurt,eigenaarHeeftBeurt);
    }

    @Test
    public void testTegenstanderWisseltBeurtNaZet(){
        Bak[] spelbord=maakBord();

        boolean tegenstanderHadBeurt=spelbord[0].eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();
        ((Put)spelbord[0]).doeZet();
        boolean tegenstanderHeeftBeurt=spelbord[0].eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(tegenstanderHadBeurt,tegenstanderHeeftBeurt);
    }
    @Test
    public void testEigenaarWisseltBeurtNaZetMetKalahaErtussen(){
        Bak[] spelbord=maakBord(2);

        boolean eigenaarHadBeurt=spelbord[0].eigenaar.isEigenaarAanDeBeurt();
        ((Put)spelbord[0]).doeZet();
        boolean eigenaarHeeftBeurt=spelbord[0].eigenaar.isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(eigenaarHadBeurt,eigenaarHeeftBeurt);
    }
    @Test
    public void testTegenstanderWisseltBeurtNaZetMetKalahaErtussen(){
        Bak[] spelbord=maakBord(2);

        boolean tegenstanderHadBeurt=spelbord[0].eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();
        ((Put)spelbord[0]).doeZet();
        boolean tegenstanderHeeftBeurt=spelbord[0].eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt();

        Assertions.assertNotEquals(tegenstanderHadBeurt,tegenstanderHeeftBeurt);
    }

    @Test
    public void testGeenBeurtwisselIndienLaatsteBalInEigenKalaha1(){
        Bak[] spelbord =maakBord(4);

        ((Put)spelbord[0]).doeZet();

        Assertions.assertTrue(spelbord[4].eigenaar.isEigenaarAanDeBeurt());
    }

    @Test
    public void testGeenBeurtwisselIndienLaatsteBalInEigenKalaha2(){
        Bak[] spelbord =maakBord(4);

        ((Put)spelbord[0]).doeZet();

        Assertions.assertNotEquals(
                spelbord[4].eigenaar.isEigenaarAanDeBeurt(),spelbord[4].eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt()
        );
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
