package mancala.domain;

import mancala.domain.bakken.Bak;
import mancala.domain.bakken.Put;

import static mancala.domain.Spelmaker.maakBord;

public class MancalaSpel implements Playable{

    public void MancalaSpel(String playerone, String playertwo){
        speler1=playerone;
        speler2=playertwo;
    }
    final Bak[] spelbord=maakBord();
    final private String speler1;
    final private String speler2;

    public String getNameOfPlayerOne(){return speler1;}
    public String getNameOfPlayerTwo(){return speler2;}

    public boolean isPlayersTurn(String spelernaam){
        return switch(spelernaam) {
            case speler1: yield spelbord[0].eigenaar.isEigenaarAanDeBeurt();
            case speler2: yield spelbord[7].eigenaar.isEigenaarAanDeBeurt();
        };
    }
    public void playPit(int index){
        ((Put) spelbord[index]).doeZet();
    }

    public int getStonesForPit(int index){
        return spelbord[index].vraagAantalBallenOp();
    }
}
