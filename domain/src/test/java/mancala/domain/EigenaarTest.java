package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EigenaarTest {
    @Test
    public void testErZijnTweeEigenaars(){
        Eigenaar eigenaar=new Eigenaar();

        Assertions.assertInstanceOf(Eigenaar.class,eigenaar);
        Assertions.assertInstanceOf(Eigenaar.class,eigenaar.vraagTegenstanderOp());
    }

    @Test
    public void eenEigenaarHeeftDeBeginBeurt(){
        Eigenaar eigenaar=new Eigenaar();

        Assertions.assertNotEquals(eigenaar.isEigenaarAanDeBeurt(),eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt());
    }

    @Test
    public void testEigenaarKanSpelBeeindigen(){
        Eigenaar eigenaar=new Eigenaar();

        eigenaar.beeindigSpel();

        Assertions.assertFalse(eigenaar.isEigenaarAanDeBeurt());
        Assertions.assertFalse(eigenaar.vraagTegenstanderOp().isEigenaarAanDeBeurt());
    }
}