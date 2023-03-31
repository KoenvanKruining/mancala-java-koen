package mancala.domain.bakken;

import mancala.domain.Spelmaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class zetTest {
    @Test
    public void testPutIsLeegNaZet(){
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put();
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(0,putten[0].vraagAantalBallenOp());
    }

    @Test
    public void behoudVanBallen(){
        Bak[] speelbord= Spelmaker.maakBord();
        int aantalBallenVoor=0;
        for(Bak i:speelbord) aantalBallenVoor+=i.vraagAantalBallenOp();
        Put put=(Put) speelbord[1];

        put.doeZet();

        int aantalBallenNa=0;
        for(Bak i:speelbord) aantalBallenNa+=i.vraagAantalBallenOp();

        Assertions.assertEquals(aantalBallenVoor,aantalBallenNa);
    }
}
