package mancala.domain.bakken;

import mancala.domain.Eigenaar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PutTest{
    @Test
    public void testNieuwePutHeeft4Ballen(){
        Eigenaar eigenaar=new Eigenaar(true);
        Put put=new Put(eigenaar);

        Assertions.assertEquals(4,put.vraagAantalBallenOp());
    }
}
