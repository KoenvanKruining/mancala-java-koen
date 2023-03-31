package mancala.domain.bakken;

import mancala.domain.Eigenaar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class KalahaTest {
    @Test
    public void testNieuweKalahaHeeft0Ballen(){
        Eigenaar eigenaar=new Eigenaar(true);
        Kalaha kalaha=new Kalaha(eigenaar);

        Assertions.assertEquals(0,kalaha.vraagAantalBallenOp());
    }
}