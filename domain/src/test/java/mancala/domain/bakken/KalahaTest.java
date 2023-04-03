package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;
public class KalahaTest {
    @Test
    public void testNieuweKalahaHeeft0Ballen(){
        Eigenaar eigenaar=new Eigenaar(true);
        Kalaha kalaha=new Kalaha(eigenaar);

        Assertions.assertEquals(0,kalaha.vraagAantalBallenOp());
    }
}