package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.bakken.*;

public class SpelmakerMaaktBakkenTest {
    @Test
    public void testSpelHeeft14Bakken(){
        Assertions.assertEquals(14,Spelmaker.maakBord().length);
    }

    @ParameterizedTest(name="testAlleBakkenBestaan[{index}]")
    @ValueSource(ints={0,1,2,3,4,5,6,7,8,9,10,11,12,13})
    public void testAlleBakkenBestaan(int i){
        Bak[] speelbord=Spelmaker.maakBord();

        Assertions.assertInstanceOf(Bak.class,speelbord[i]);
    }
    @Test
    public void testKalahasLiggen7UitElkaar(){
        Bak[] speelbord=Spelmaker.maakBord();
        int i=0;
        while (speelbord[i].getClass()!=Kalaha.class){
            i++;
        }

        Assertions.assertInstanceOf(Kalaha.class,speelbord[i+7]);
    }

    @ParameterizedTest(name="testBeideSpeelhelftenZijnGelijk[{index}]")
    @ValueSource(ints={0,1,2,3,4,5,6})
    public void testBeideSpeelhelftenZijnGelijk(int i){
        Bak[] speelbord=Spelmaker.maakBord();

        Assertions.assertEquals(speelbord[i].getClass(),speelbord[i+7].getClass());
    }

    @Test
    public void testSpeelhelftHeeft6Putten(){
        Bak[] speelbord=Spelmaker.maakBord();

        int aantalPutten=0;
        for(int i=0;i<7;i++){
            if(speelbord[i] instanceof Put) aantalPutten++;
        }

        Assertions.assertEquals(6,aantalPutten);
    }
}
