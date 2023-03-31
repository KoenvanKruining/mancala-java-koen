package mancala.domain.bakken;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class zetTest {
    @Test
    public void testPutIsLeegNaZet(){
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put();
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(0,putten[0].vraagAantalBallenOp());
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4})
    public void behoudVanBallen(int putPositie){
        Put[] putten=new Put[5];
        for(int i=0;i<5;i++) putten[i]=new Put();
        for(int i=0;i<4;i++) putten[i].buurBak=putten[i+1];

        putten[0].doeZet();

        Assertions.assertEquals(5,putten[putPositie].vraagAantalBallenOp());
    }
}
