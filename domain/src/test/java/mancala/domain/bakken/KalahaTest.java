package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;
import static mancala.domain.Spelmaker.maakBord;

public class KalahaTest {
    @Test
    public void testNieuweKalahaHeeft0Ballen(){
        Eigenaar eigenaar=new Eigenaar();
        Kalaha kalaha=new Kalaha(eigenaar);

        Assertions.assertEquals(0,kalaha.vraagAantalBallenOp());
    }
    @Test
    public void testKalahasHebbenVerschillendeEigenaars(){
        Bak[] speelbord=maakBord(1);

        Assertions.assertNotEquals(speelbord[1].eigenaar,speelbord[3].eigenaar);
    }
}