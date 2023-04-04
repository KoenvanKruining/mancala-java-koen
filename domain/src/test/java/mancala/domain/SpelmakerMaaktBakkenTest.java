package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.bakken.*;

public class SpelmakerMaaktBakkenTest {
    @Test
    public void testSpelHeeft14Bakken(){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();

        Assertions.assertEquals(14,Spelmaker.maakBord(eigenaars).length);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6,7,8,9,10,11,12,13})
    public void testAlleBakkenBestaan(int i){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();
        Bak[] speelbord=Spelmaker.maakBord(eigenaars);

        Assertions.assertInstanceOf(Bak.class,speelbord[i]);
    }
    @Test
    public void testKalahasLiggen7UitElkaar(){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();
        Bak[] speelbord=Spelmaker.maakBord(eigenaars);
        int i=0;
        while (speelbord[i].getClass()!=Kalaha.class){
            i++;
        }

        Assertions.assertInstanceOf(Kalaha.class,speelbord[i+7]);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6})
    public void testBeideSpeelhelftenZijnGelijk(int i){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();
        Bak[] speelbord=Spelmaker.maakBord(eigenaars);

        Assertions.assertEquals(speelbord[i].getClass(),speelbord[i+7].getClass());
    }

    @Test
    public void testSpeelhelftHeeft6Putten(){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();
        Bak[] speelbord=Spelmaker.maakBord(eigenaars);

        int aantalPutten=0;
        for(int i=0;i<7;i++){
            if(speelbord[i] instanceof Put) aantalPutten++;
        }

        Assertions.assertEquals(6,aantalPutten);
    }

/*    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6})
    public void testTegenoverliggendePuttenHebbenVerschillendeEigenaars(int i){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();
        Bak[] speelbord=Spelmaker.maakBord(eigenaars);

        Assertions.assertNotEquals(speelbord[i].eigenaar,speelbord[i+7].eigenaar);
    }*/
}
