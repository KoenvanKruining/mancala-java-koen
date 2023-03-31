package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public abstract class Bak {
    protected int ballen;
    public Bak buurBak; //Dit is niet netjes. Moet ik nog op terugkomen
    protected final Eigenaar eigenaar;

    public Bak(Eigenaar eigenaar){this.eigenaar=eigenaar;}
    public int vraagAantalBallenOp(){return ballen;}

    protected void ontvang(int aantalBallen){
        this.ballen+=1;
        if(aantalBallen>1)  buurBak.ontvang(aantalBallen-1);
        if(aantalBallen==1) eigenaar.wisselBeurt();
    }
}
