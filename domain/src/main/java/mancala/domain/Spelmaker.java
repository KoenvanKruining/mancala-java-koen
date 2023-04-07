package mancala.domain;

import mancala.domain.bakken.*;

public class Spelmaker {
    public static Bak[] maakBord(int aantalputtenperspeler){
        Bak[] speelbord =new Bak[2*aantalputtenperspeler +2];
        Eigenaar eigenaar=new Eigenaar();

        for(int i=0;i<speelbord.length;i++) {
            if(i%(aantalputtenperspeler+1)==aantalputtenperspeler){
                speelbord[i] = new Kalaha(eigenaar);
                eigenaar=eigenaar.vraagTegenstanderOp();
            }
            else speelbord[i] = new Put(eigenaar);

            if(i>0) speelbord[i-1].setBuurbak(speelbord[i]);
        }
        speelbord[speelbord.length-1].setBuurbak(speelbord[0]);

        for(int i=0;i<speelbord.length/2-1;i++) {
            ((Put) speelbord[i]).kiesOverbuurPut(((Put) speelbord[speelbord.length - 2 - i]));
        }

        return speelbord;
    }
    public static Bak[] maakBord() {return maakBord(6);}
}
