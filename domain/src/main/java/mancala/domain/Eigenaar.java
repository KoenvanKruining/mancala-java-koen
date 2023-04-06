package mancala.domain;

import mancala.domain.bakken.Put;

public class Eigenaar {
    private boolean aanDeBeurt;
    private final Eigenaar tegenstander;

    Put startput;

    public Eigenaar vraagTegenstanderOp(){return tegenstander;}

    public Eigenaar(){
        aanDeBeurt=true;
        this.tegenstander=new Eigenaar(this);
    }
    public Eigenaar(Eigenaar tegenstander){
        aanDeBeurt=false;
        this.tegenstander=tegenstander;
    }

    public boolean isEigenaarAanDeBeurt(){return aanDeBeurt;}

    public void wisselBeurt(){
        aanDeBeurt= !aanDeBeurt;
        tegenstander.wisselBeurtOok();
    }
    private void wisselBeurtOok(){aanDeBeurt= !aanDeBeurt;}

    public boolean isSpelVoorbij() throws NullPointerException{
        if(aanDeBeurt)return startput.eindeChecker();
        else return vraagTegenstanderOp().startput.eindeChecker();
    }

    public void beeindigSpel(){
        aanDeBeurt=false;
        tegenstander.beeindigSpelOok();
    }
    private void beeindigSpelOok(){aanDeBeurt=false;}
}