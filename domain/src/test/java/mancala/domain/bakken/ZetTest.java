package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static mancala.domain.Spelmaker.maakBord;

import static mancala.domain.Spelmaker.maakBord;


public class ZetTest {
    @Test
    public void testPutIsLeegNaZet(){
        Bak[] spelbord=maakBord();

        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(0,spelbord[0].vraagAantalBallenOp());
    }

    @ParameterizedTest(name="behoudVanBallen[{index}]")
    @ValueSource(ints={1,2,3,4})
    public void behoudVanBallen(int putPositie){
        Bak[] spelbord=maakBord();

        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(5,spelbord[putPositie].vraagAantalBallenOp());
    }

    @Test
    public void kalahaHoudtEenBalVastAlsEigenaarAanZet(){
        Bak[] spelbord=maakBord(3);

        ((Put)spelbord[2]).doeZet();

        Assertions.assertEquals(1,spelbord[3].vraagAantalBallenOp());
    }

    @ParameterizedTest(name="kalahaGeeftAllesMinEenAlsVanEigenaarAanZet[{index}]")
    @ValueSource(ints={4,5,6})
    public void kalahaGeeftAllesMinEenAlsVanEigenaarAanZet(int j){
        Bak[] spelbord=maakBord(3);

        ((Put)spelbord[2]).doeZet();

        Assertions.assertEquals(5,spelbord[j].vraagAantalBallenOp());
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
        Bak[] spelbord=maakBord(2);

        ((Put)spelbord[1]).doeZet();

        Assertions.assertEquals(0,spelbord[5].vraagAantalBallenOp());
    }
}

