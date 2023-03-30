package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.Spelmaker;
import mancala.domain.bakken.*;

public class SpelmakerTest {
    @Test
    public void testSpelHeeft14Bakken(){
        Assertions.assertEquals(14,Spelmaker.maakBord().length);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6,7,8,9,10,11,12,13})
    public void testAlleBakkenBestaan(int i){
        Bak[] speelbord=Spelmaker.maakBord();

        Assertions.assertNotNull(speelbord[i]);
    }


}
