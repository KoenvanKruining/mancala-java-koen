package mancala.domain;

public class Eigenaar {
    private boolean aanDeBeurt;
    private Eigenaar tegenstander;

    public void setTegenstander(Eigenaar tegenstander){
        this.tegenstander=tegenstander;
    }

    public Eigenaar(boolean beginBeurt){this.aanDeBeurt=beginBeurt;}

    public boolean isEigenaarAanDeBeurt(){return aanDeBeurt;}

    public void wisselBeurt(){
        aanDeBeurt= !aanDeBeurt;
        tegenstander.wisselBeurtOok();
    }
    private void wisselBeurtOok(){aanDeBeurt= !aanDeBeurt;}
}