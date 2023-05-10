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

    @Test
    public void testBeideSpeelhelftenZijnGelijk(){
        Bak[] speelbord=Spelmaker.maakBord();
        Class<?>[] speelhelft1= new Class<?>[7];
        Class<?>[] speelhelft2= new Class<?>[7];

        for(int i=0; i<7; i++){
            speelhelft1[i]=speelbord[i].getClass();
            speelhelft2[i]=speelbord[i+7].getClass();
        }

        Assertions.assertArrayEquals(speelhelft1,speelhelft2);
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

    @Test
    public void testPuttenKrijgen4BallenMee(){
        Bak[] speelbord=Spelmaker.maakBord();
        int[] verwachtAantalBallen=new int[14];
        int[] aantalballenperput=new int[14];

        for(int i=0;i<14;i++){
            if(speelbord[i] instanceof Put) verwachtAantalBallen[i]=4;
            else verwachtAantalBallen[i]=0;
            aantalballenperput[i]= speelbord[i].vraagAantalBallenOp();        }

        Assertions.assertArrayEquals(verwachtAantalBallen,aantalballenperput);
    }
}
