package mancala.domain;

import mancala.domain.bakken.*;

public class Spelmaker {
    public static Eigenaar[] maakEigenaars(){
        Eigenaar[] eigenaar=new Eigenaar[2];

        eigenaar[0]=new Eigenaar(true);
        eigenaar[1]=new Eigenaar(false);

        return eigenaar;
    }
    public static Bak[] maakBord(){
        Bak[] speelbord=new Bak[14];
        for(int i=0;i<speelbord.length;i++) {
            if(i%7==0) speelbord[i] = new Kalaha();
            else speelbord[i] = new Put();
        }
        for(int i=0;i<speelbord.length;i++){
            int buurPositie=(i+1)%14;
            speelbord[i].buurBak=speelbord[buurPositie];
        }

        return speelbord;
    }

}
