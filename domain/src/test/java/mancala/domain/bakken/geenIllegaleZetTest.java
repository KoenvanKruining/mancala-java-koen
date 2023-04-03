package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;

import static mancala.domain.Spelmaker.maakEigenaars;

public class geenIllegaleZetTest {
    @Test
    public void geenZetInBakAlsEigenaarNietAanDeBeurtIsTest1(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[10];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=5;i<10;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<9;i++) putten[i].buurBak=putten[i+1];

        putten[5].doeZet();


        Assertions.assertEquals(4,putten[5].vraagAantalBallenOp());
    }
    @Test
    public void geenZetInBakAlsEigenaarNietAanDeBeurtIsTest2(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[10];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=5;i<10;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<9;i++) putten[i].buurBak=putten[i+1];

        putten[5].doeZet();


        Assertions.assertTrue(eigenaars[0].isEigenaarAanDeBeurt());
    }
    @Test
    public void geenZetInLegeBakTest1(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[10];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=5;i<10;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<9;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();
        putten[5].doeZet();
        putten[0].doeZet();

        Assertions.assertTrue(eigenaars[0].isEigenaarAanDeBeurt());
    }

    @Test
    public void geenZetInLegeBakTest2(){
        Eigenaar[] eigenaars=maakEigenaars();
        Put[] putten=new Put[10];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        for(int i=5;i<10;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<9;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();
        putten[5].doeZet();
        putten[0].doeZet();

        Assertions.assertEquals(5,putten[1].vraagAantalBallenOp());
    }

    @Test
    public void geenZetInKalahaTest1(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[11];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        putten[5]=new Kalaha(eigenaars[0]);
        for(int i=6;i<11;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<10;i++) putten[i].buurBak=putten[i+1];

        putten[1].doeZet();
        putten[6].doeZet();
        putten[5].doeZet();

        Assertions.assertTrue(eigenaars[0].isEigenaarAanDeBeurt());
    }

    @Test
    public void geenZetInKalahaTest2(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] putten=new Bak[11];
        for(int i=0;i<5;i++) putten[i]=new Put(eigenaars[0]);
        putten[5]=new Kalaha(eigenaars[0]);
        for(int i=6;i<11;i++) putten[i]=new Put(eigenaars[1]);
        for(int i=0;i<10;i++) putten[i].buurBak=putten[i+1];

        putten[1].doeZet();
        putten[5].doeZet();

        Assertions.assertEquals(4,putten[6].vraagAantalBallenOp());
    }
}
