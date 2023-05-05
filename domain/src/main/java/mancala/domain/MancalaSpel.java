package mancala.domain;

import mancala.domain.bakken.Bak;
import mancala.domain.bakken.Put;

import static mancala.domain.Playable.Winner.*;
import static mancala.domain.Spelmaker.maakBord;

public class MancalaSpel implements Playable {
    final Bak[] spelbord;
    private final String speler1;
    private final String speler2;
    private boolean iseindespel = false;
    private Winner winner=NO_ONE;

    public MancalaSpel(String playerone, String playertwo,int aantalputtenperspeler, int aantalballenperput) {
        spelbord= maakBord(aantalputtenperspeler,aantalballenperput);
        speler1 = playerone;
        speler2 = playertwo;
    }
    public MancalaSpel(String playerone, String playertwo,int aantalputtenperspeler){
        spelbord= maakBord(aantalputtenperspeler);
        speler1 = playerone;
        speler2 = playertwo;
    }
    public MancalaSpel(String playerone, String playertwo){
        spelbord= maakBord();
        speler1 = playerone;
        speler2 = playertwo;
    }
    public String getNameOfPlayerOne() {return speler1;}

    public String getNameOfPlayerTwo() {return speler2;}

    public int getPitsPerPlayer() {return spelbord.length/2;}

    public boolean isPlayersTurn(String spelernaam) {
        if(spelernaam==speler1) {
            return spelbord[0].eigenaar.isEigenaarAanDeBeurt();
        } else if(spelernaam==speler2){
            return spelbord[spelbord.length/2].eigenaar.isEigenaarAanDeBeurt();
        } else return false;
    }

    public void playPit(int index) {
        Bak.uitkomst status=((Put) spelbord[index]).doeZet();
        if(status!=Bak.uitkomst.SPELEND) {
            iseindespel=true;
            if (status == Bak.uitkomst.GELIJK) {winner = DRAW;}
            else if (
                (status == Bak.uitkomst.GEWONNEN && index < spelbord.length/2)||(status == Bak.uitkomst.VERLOREN && index >= spelbord.length/2)
            ) {winner= PLAYER_1;}
            else winner= PLAYER_2;
        }
    }

    public int getStonesForPit(int index) {
        return spelbord[index].vraagAantalBallenOp();
    }

    public boolean isEndOfGame() {return iseindespel;}

    public Winner getWinner(){return winner;}
}
