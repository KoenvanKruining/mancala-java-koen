package mancala.domain;

public class Eigenaar {
    private boolean aanDeBeurt;
    public Eigenaar tegenstander; //Dit is niet netjes. Moet ik nog op terugkomen

    public Eigenaar(boolean beginBeurt){this.aanDeBeurt=beginBeurt;}

    public boolean isEigenaarAanDeBeurt(){return aanDeBeurt;}

    public void wisselBeurt(){
        aanDeBeurt= !aanDeBeurt;
        tegenstander.wisselBeurtOok();
    }
    private void wisselBeurtOok(){aanDeBeurt= !aanDeBeurt;}
}