package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.Eigenaar;

public class eigenaarTest{
    @ParameterizedTest
    @ValueSource(ints={0,1})
    public void testErZijnTweeEigenaars(int i){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();

        Assertions.assertInstanceOf(Eigenaar.class,eigenaars[i]);
    }

    @Test
    public void eenEigenaarHeeftDeBeginBeurt(){
        Eigenaar[] eigenaars=Spelmaker.maakEigenaars();

        Assertions.assertNotEquals(eigenaars[0].isEigenaarAanDeBeurt(),eigenaars[1].isEigenaarAanDeBeurt());
    }
}