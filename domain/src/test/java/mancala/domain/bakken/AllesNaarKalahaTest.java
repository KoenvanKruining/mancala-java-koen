package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mancala.domain.Eigenaar;
public class AllesNaarKalahaTest {
    @Test
    public void testallePuttenZijnLeeg() {
        Eigenaar eigenaar = new Eigenaar();
        Bak[] putten=new Bak[3];
        putten[0]=new Put(eigenaar);
        putten[1]=new Put(eigenaar);
        putten[2]=new Kalaha(eigenaar);
        putten[0].setBuurbak(putten[1]);
        putten[1].setBuurbak(putten[2]);

        putten[0].allesNaarKalaha();

        int[] verwachtaantalballen={0,0,8};
        int[] ballen=new int[3];
        for(int i=0;i<3;i++) ballen[i]=putten[i].vraagAantalBallenOp();

        Assertions.assertArrayEquals(verwachtaantalballen,ballen);
    }

    @Test
    public void testAllesNaarKalahaStoptBijKalaha1(){
        Eigenaar eigenaar = new Eigenaar();
        Bak[] putten=new Bak[4];
        putten[0]=new Kalaha(eigenaar.vraagTegenstanderOp());
        putten[1]=new Put(eigenaar);
        putten[2]=new Put(eigenaar);
        putten[3]=new Kalaha(eigenaar);
        putten[0].setBuurbak(putten[1]);
        putten[1].setBuurbak(putten[2]);
        putten[2].setBuurbak(putten[3]);

        putten[0].allesNaarKalaha();

        int[] verwachtaantalballen={0,4,4,0};
        int[] ballen=new int[4];
        for(int i=0;i<3;i++) ballen[i]=putten[i].vraagAantalBallenOp();

        Assertions.assertArrayEquals(verwachtaantalballen,ballen);
    }

    @Test
    public void testAllesNaarKalahaStoptBijKalaha2(){
        Eigenaar eigenaar = new Eigenaar();
        Bak[] putten=new Bak[4];
        putten[0]=new Kalaha(eigenaar.vraagTegenstanderOp());
        putten[1]=new Put(eigenaar);
        putten[2]=new Put(eigenaar);
        putten[3]=new Kalaha(eigenaar);
        putten[0].setBuurbak(putten[1]);
        putten[1].setBuurbak(putten[2]);
        putten[2].setBuurbak(putten[3]);

        int ballen=putten[0].allesNaarKalaha();

        Assertions.assertEquals(0,ballen);
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
