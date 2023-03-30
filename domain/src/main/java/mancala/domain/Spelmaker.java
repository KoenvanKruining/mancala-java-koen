package mancala.domain;

import mancala.domain.bakken.*;

public class Spelmaker {
    public static Bak[] maakBord(){
        Bak[] speelbord=new Bak[14];

        for(int i=0;i<speelbord.length;i++) speelbord[i]=new Put();

        return speelbord;
    }
}
