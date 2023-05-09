package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mancala.domain.Eigenaar;
public class AllesNaarKalahaTest {
    @ParameterizedTest(name="testallePuttenZijnLeeg[{index}]")
    @ValueSource(ints={0,1})
    public void testallePuttenZijnLeeg(int i) {
        Eigenaar eigenaar = new Eigenaar();
        Bak[] putten=new Bak[3];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Kalaha(eigenaar);
        putten[0].setBuurbak(putten[1]);
        putten[1].setBuurbak(putten[2]);

        putten[0].allesNaarKalaha();

        Assertions.assertEquals(0,putten[i].vraagAantalBallenOp());
    }

    @Test
    public void testKalahaWordtGevuld(){
        Eigenaar eigenaar = new Eigenaar();
        Bak[] putten=new Bak[3];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Kalaha(eigenaar);
        putten[0].setBuurbak(putten[1]);
        putten[1].setBuurbak(putten[2]);

        putten[0].allesNaarKalaha();

        Assertions.assertEquals(8,putten[2].vraagAantalBallenOp());
    }

    @Test
    public void testAllesNaarKalahaGeeftInhoudVanKalahaTerug(){
        Eigenaar eigenaar = new Eigenaar();
        Bak[] putten=new Bak[3];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Kalaha(eigenaar);
        putten[0].setBuurbak(putten[1]);
        putten[1].setBuurbak(putten[2]);

        int eindstand=putten[0].allesNaarKalaha();

        Assertions.assertEquals(putten[2].vraagAantalBallenOp(),eindstand);
    }
}
