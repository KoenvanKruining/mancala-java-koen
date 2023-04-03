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

    public void kiesOverbuurPut(Bak overbuurput){}
    void kiesOverbuurputOok(Bak overbuurput){}
    public int vraagAantalBallenOp(){return ballen;}

    public void doeZet(){}

    abstract void ontvang(int aantalBallen);

    abstract void ballenNaarKalaha(int ballen);

    void putjePlunderen(){}
}
