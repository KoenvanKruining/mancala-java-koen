package mancala.domain;

import mancala.domain.bakken.*;

public class Spelmaker {
    public static Eigenaar[] maakEigenaars(){
        Eigenaar[] eigenaar=new Eigenaar[2];

        eigenaar[0]=new Eigenaar(true);
        eigenaar[1]=new Eigenaar(false);

        eigenaar[0].setTegenstander(eigenaar[1]);
        eigenaar[1].setTegenstander(eigenaar[0]);

        return eigenaar;
    }
    public static Bak[] maakBord(){
        Eigenaar[] eigenaars=maakEigenaars();
        Bak[] speelbord =new Bak[14];
        Eigenaar eigenaar=eigenaars[0];

        for(int i=0;i<speelbord.length;i++) {
            if(i%7==6){
                speelbord[i] = new Kalaha(eigenaar);
                eigenaar=eigenaar.vraagTegenstanderOp();
            }
            else speelbord[i] = new Put(eigenaar);

            if(i>1) speelbord[i-1].setBuurbak(speelbord[i]);
        }
        speelbord[13].setBuurbak(speelbord[0]);

        for(int i=0;i<speelbord.length/2-1;i++)
            ((Put)speelbord[i]).kiesOverbuurPut(((Put)speelbord[12-i]));

        return speelbord;
    }

}
