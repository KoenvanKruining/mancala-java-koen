package mancala.domain;

import mancala.domain.bakken.*;

public class Spelmaker {
    public static Eigenaar[] maakEigenaars(){
        Eigenaar[] eigenaar=new Eigenaar[2];

        eigenaar[0]=new Eigenaar(true);
        eigenaar[1]=new Eigenaar(false);

        eigenaar[0].tegenstander=eigenaar[1];
        eigenaar[1].tegenstander=eigenaar[0];

        return eigenaar;
    }
    public static Bak[] maakBord(Eigenaar[] eigenaars){
        Bak[] speelbord=new Bak[14];
        for(int i=0;i<speelbord.length;i++) {
            if(i%7==0) speelbord[i] = new Kalaha(eigenaars[0]);
            else speelbord[i] = new Put(eigenaars[0]);
        }
        for(int i=0;i<speelbord.length;i++){
            int buurPositie=(i+1)%14;
            speelbord[i].buurBak=speelbord[buurPositie];
        }

        return speelbord;
    }

}
