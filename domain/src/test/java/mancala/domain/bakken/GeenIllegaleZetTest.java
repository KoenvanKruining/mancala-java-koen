package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;

import static mancala.domain.Spelmaker.maakBord;

public class GeenIllegaleZetTest {
    @Test
    public void geenZetInBakAlsEigenaarNietAanDeBeurtIsTest1(){
        Eigenaar eigenaar=new Eigenaar();
        Put[] putten=new Put[10];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaar);
        for(int i=5;i<10;i++) putten[i]=new Put(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<9;i++) putten[i].buurBak=putten[i+1];

        putten[5].doeZet();


        Assertions.assertEquals(4,putten[5].vraagAantalBallenOp());
    }
    @Test
    public void geenZetInBakAlsEigenaarNietAanDeBeurtIsTest2(){
        Eigenaar eigenaar=new Eigenaar();
        Put[] putten=new Put[10];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaar);
        for(int i=5;i<10;i++) putten[i]=new Put(eigenaar.vraagTegenstanderOp());
        for(int i=0;i<9;i++) putten[i].buurBak=putten[i+1];

        putten[5].doeZet();


        Assertions.assertTrue(eigenaar.isEigenaarAanDeBeurt());
    }

    @Test
    public void geenZetInLegeBakTest1(){
        Bak[] spelbord= maakBord(5);

        ((Put)spelbord[0]).doeZet();
        ((Put)spelbord[6]).doeZet();
        ((Put)spelbord[0]).doeZet();

        Assertions.assertEquals(5,spelbord[1].vraagAantalBallenOp());
    }
    @Test
    public void geenZetInLegeBakTest2(){
        Bak[] spelbord= maakBord(5);

        ((Put)spelbord[0]).doeZet();
        ((Put)spelbord[6]).doeZet();
        ((Put)spelbord[0]).doeZet();

        Assertions.assertTrue(spelbord[0].eigenaar.isEigenaarAanDeBeurt());
    }

    @Test
    public void geenZetInKalahaTest(){
        Bak[] spelbord=maakBord(4);

        Assertions.assertThrows(ClassCastException.class, () ->{
            ((Put)spelbord[0]).doeZet();
            ((Put)spelbord[4]).doeZet();
        });

    }
}
