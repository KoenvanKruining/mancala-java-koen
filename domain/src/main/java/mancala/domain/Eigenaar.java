package mancala.domain;

public class Eigenaar {
    private boolean aanDeBeurt;
    private final Eigenaar tegenstander;

    public Eigenaar vraagTegenstanderOp(){return tegenstander;}

    public Eigenaar(){
        this.aanDeBeurt=true;
        this.tegenstander=new Eigenaar(this);
    }
    public Eigenaar(Eigenaar tegenstander){
        this.aanDeBeurt=false;
        this.tegenstander=tegenstander;
    }

    public boolean isEigenaarAanDeBeurt(){return aanDeBeurt;}

    public void wisselBeurt(){
        aanDeBeurt= !aanDeBeurt;
        tegenstander.wisselBeurtOok();
    }
    private void wisselBeurtOok(){aanDeBeurt= !aanDeBeurt;}
}