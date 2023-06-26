package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.bakken.*;

public class SpelmakerMaaktBakkenMetOptiesTest {
    @Test
    public void testSpelHeeft6Bakken(){
        Assertions.assertEquals(6,Spelmaker.maakBord(2,3).length);
    }

    @ParameterizedTest(name="testAlleBakkenBestaan[{index}]")
    @ValueSource(ints={0,1,2,3,4,5})
    public void testAlleBakkenBestaan(int i){
        Bak[] speelbord=Spelmaker.maakBord(2,3);

        Assertions.assertInstanceOf(Bak.class,speelbord[i]);
    }
    @Test
    public void testKalahasLiggen3UitElkaar(){
        Bak[] speelbord=Spelmaker.maakBord(2,3);
        int i=0;
        while (speelbord[i].getClass()!=Kalaha.class){
            i++;
        }

        Assertions.assertInstanceOf(Kalaha.class,speelbord[i+3]);
    }

    @Test
    public void testBeideSpeelhelftenZijnGelijk(){
        Bak[] speelbord=Spelmaker.maakBord(2,3);
        Class<?>[] speelhelft1= new Class<?>[3];
        Class<?>[] speelhelft2= new Class<?>[3];

        for(int i=0; i<3; i++){
            speelhelft1[i]=speelbord[i].getClass();
            speelhelft2[i]=speelbord[i+3].getClass();
        }

        Assertions.assertArrayEquals(speelhelft1,speelhelft2);
    }

    @Test
    public void testSpeelhelftHeeft2Putten(){
        Bak[] speelbord=Spelmaker.maakBord(2,3);

        int aantalPutten=0;
        for(int i=0;i<3;i++){
            if(speelbord[i] instanceof Put) aantalPutten++;
        }

        Assertions.assertEquals(2,aantalPutten);
    }

    @Test
    public void testPuttenKrijgenOptioneleAantalBallenMee(){
        Bak[] speelbord=Spelmaker.maakBord(2,3);
        int[] verwachtAantalBallen=new int[6];
        int[] aantalballenperput=new int[6];

        for(int i=0;i<6;i++){
            if(speelbord[i] instanceof Put) verwachtAantalBallen[i]=3;
            else verwachtAantalBallen[i]=0;
            aantalballenperput[i]= speelbord[i].vraagAantalBallenOp();        }

        Assertions.assertArrayEquals(verwachtAantalBallen,aantalballenperput);
    }
}
