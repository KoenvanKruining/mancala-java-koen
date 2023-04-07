package mancala.domain.bakken;

import mancala.domain.Eigenaar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static mancala.domain.Spelmaker.maakBord;

public class PutTest{
    @Test
    public void testNieuwePutHeeft4Ballen(){
        Eigenaar eigenaar=new Eigenaar();
        Put put=new Put(eigenaar);

        Assertions.assertEquals(4,put.vraagAantalBallenOp());
    }

    @Test
    public void testOverbuurputtenVerschillendeEigenaars(){
        Bak[] speelbord=maakBord(1);

        Assertions.assertNotEquals(speelbord[0].eigenaar,speelbord[2].eigenaar);
    }
}
