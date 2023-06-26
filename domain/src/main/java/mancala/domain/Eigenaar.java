package mancala.domain;

public class Eigenaar {
    private boolean aanDeBeurt;
    private final Eigenaar tegenstander;

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
        aanDeBeurt= ! aanDeBeurt;
        tegenstander.aanDeBeurt= ! tegenstander.aanDeBeurt;
    }

    public void beeindigSpel(){
        aanDeBeurt=false;
        tegenstander.aanDeBeurt=false;
    }
}