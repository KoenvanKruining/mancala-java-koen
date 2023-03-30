package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PutTest{
    @Test
    public void testNieuwePutHeeft4Ballen(){
        Put put=new Put();

        Assertions.assertEquals(4,put.vraagAantalBallenOp());
    }
}
