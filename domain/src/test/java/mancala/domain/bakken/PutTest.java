package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Spelmaker;
import mancala.domain.bakken.Put;

public class PutTest{
    @Test
    public void testNieuwePutHeeft4Ballen(){
        Put put=new Put();

        Assertions.assertEquals(4,put.vraagAantalBallenOp());
    }

    @Test
    public void testPutIsLeegNaZet(){
        Put put=new Put();

        put.doeZet();

        Assertions.assertEquals(0,put.vraagAantalBallenOp());
    }
}
