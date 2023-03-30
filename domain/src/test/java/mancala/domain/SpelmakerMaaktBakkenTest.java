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

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6,7,8,9,10,11,12,13})
    public void testAlleBakkenBestaan(int i){
        Bak[] speelbord=Spelmaker.maakBord();

        Assertions.assertInstanceOf(Bak.class,speelbord[i]);
    }
    @ParameterizedTest
    @ValueSource(ints={0,7})
    public void test0en7ZijnKalahas(int i){
        Bak[] speelbord=Spelmaker.maakBord();

        Assertions.assertInstanceOf(Kalaha.class,speelbord[i]);
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5,6,8,9,10,11,12,13})
    public void testAlleBakjesNiet0of7ZijnPutten(int i){
        Bak[] speelbord=Spelmaker.maakBord();

        Assertions.assertInstanceOf(Put.class,speelbord[i]);
    }
}
