package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public abstract class Bak {
    int ballen;
    Bak buurBak;
    final Eigenaar eigenaar;

    public Bak(Eigenaar eigenaar){this.eigenaar=eigenaar;}
    public void setBuurbak(Bak buur){
        this.buurBak=buur;
    }
    public int vraagAantalBallenOp(){return ballen;}

    protected void ontvang(int aantalBallen){
        this.ballen+=1;
        if(aantalBallen>1)  buurBak.ontvang(aantalBallen-1);
        if(aantalBallen==1) eigenaar.wisselBeurt();
    }
}
