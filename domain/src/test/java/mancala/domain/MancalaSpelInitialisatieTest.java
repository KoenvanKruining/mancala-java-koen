package mancala.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MancalaSpelInitialisatieTest {
    @Test
    public void SpelerNamenWordenGoedOpgegeven(){
        Playable spel=new MancalaSpel("Rick","Viviyan");
        Assertions.assertEquals(spel.getNameOfPlayerOne(),"Rick");
        Assertions.assertEquals(spel.getNameOfPlayerTwo(),"Viviyan");
    }

    @Test
    public void SpelLooptBijAanmaak(){
        Playable spel=new MancalaSpel("Rick","Viviyan");
        Assertions.assertFalse(spel.isEndOfGame());
        Assertions.assertEquals(spel.getWinner(), Playable.Winner.NO_ONE);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,7,8,9,10,11,12})
    public void PuttenStartenMet4Ballen1(int i){
        Playable spel=new MancalaSpel("Rick", "Viviyan");
        Assertions.assertEquals(4,spel.getStonesForPit(i));
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,3,4})
    public void PuttenStartenMet4Ballen2(int i){
        Playable spel=new MancalaSpel("Rick", "Viviyan",2);
        Assertions.assertEquals(4,spel.getStonesForPit(i));
    }
    @ParameterizedTest
    @ValueSource(ints={0,1,3,4})
    public void PuttenStartenMetOpgegevenAantalBallen2(int i){
        Playable spel=new MancalaSpel("Rick", "Viviyan",2,2);
        Assertions.assertEquals(2,spel.getStonesForPit(i));
    }
    @ParameterizedTest
    @ValueSource(ints={6,13})
    public void KalahasStartenMet0Ballen1(int i){
        Playable spel=new MancalaSpel("Rick", "Viviyan");
        Assertions.assertEquals(0,spel.getStonesForPit(i));
    }

    @ParameterizedTest
    @ValueSource(ints={2,5})
    public void KalahasStartenMet0Ballen2(int i){
        Playable spel=new MancalaSpel("Rick", "Viviyan",2);
        Assertions.assertEquals(0,spel.getStonesForPit(i));
    }

    @ParameterizedTest
    @ValueSource(ints={2,5})
    public void KalahasStartenMet0Ballen3(int i){
        Playable spel=new MancalaSpel("Rick", "Viviyan",2,2);
        Assertions.assertEquals(0,spel.getStonesForPit(i));
    }
}
