package mancala.domain;

import mancala.domain.bakken.*;

public class Spelmaker {
    public static Bak[] maakBord(){
        Bak[] speelbord =new Bak[14];
        Eigenaar eigenaar=new Eigenaar();

        for(int i=0;i<speelbord.length;i++) {
            if(i%7==6){
                speelbord[i] = new Kalaha(eigenaar);
                eigenaar=eigenaar.vraagTegenstanderOp();
            }
            else speelbord[i] = new Put(eigenaar);

            if(i>1) speelbord[i-1].setBuurbak(speelbord[i]);
        }
        speelbord[speelbord.length-1].setBuurbak(speelbord[0]);

        for(int i=0;i<speelbord.length/2-1;i++)
            ((Put)speelbord[i]).kiesOverbuurPut(((Put)speelbord[speelbord.length-2-i]));

        return speelbord;
    }

}
