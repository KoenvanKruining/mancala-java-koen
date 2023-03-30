package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class KalahaTest {
    @Test
    public void testNieuweKalahaHeeft0Ballen(){
        Kalaha kalaha=new Kalaha();

        Assertions.assertEquals(0,kalaha.vraagAantalBallenOp());
    }
}