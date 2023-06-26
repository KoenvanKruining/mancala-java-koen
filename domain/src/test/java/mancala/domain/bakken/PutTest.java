package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;
import static mancala.domain.Spelmaker.maakBord;

public class PutTest{
    @Test
    public void testNieuwePutHeeft4Ballen(){
        Eigenaar eigenaar=new Eigenaar();
        Put put1=new Put(eigenaar);
        Put put2=new Put(eigenaar,null);
        Put put3=new Put(eigenaar,put1);

        Assertions.assertEquals(4,put1.vraagAantalBallenOp());
        Assertions.assertEquals(4,put2.vraagAantalBallenOp());
        Assertions.assertEquals(4,put3.vraagAantalBallenOp());
    }

    @Test
    public void testNieuwePutheeftOptioneelAantalBallen(){
        Eigenaar eigenaar=new Eigenaar();
        Put put1=new Put(eigenaar,2);
        Put put2=new Put(eigenaar,2,null);
        Put put3=new Put(eigenaar,2,put1);

        Assertions.assertEquals(2,put1.vraagAantalBallenOp());
        Assertions.assertEquals(2,put2.vraagAantalBallenOp());
        Assertions.assertEquals(2,put3.vraagAantalBallenOp());
    }

    @Test
    public void testOverbuurputtenHebbenVerschillendeEigenaars(){
        Bak[] speelbord=maakBord(1);

        Assertions.assertNotEquals(speelbord[0].eigenaar,speelbord[2].eigenaar);
    }

    @Test
    public void testOverbuurputtenVerschillendeEigenaars(){
        Bak[] speelbord=maakBord(1);

        Assertions.assertNotEquals(speelbord[0].eigenaar,speelbord[2].eigenaar);
    }
}
