package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public abstract class Bak {
    int ballen;
    Bak buurBak;
    final Eigenaar eigenaar;

    public Bak(Eigenaar eigenaar){this.eigenaar=eigenaar;}
    public void setBuurbak(Bak buur){buurBak=buur;}

    public int vraagAantalBallenOp(){return ballen;}

    abstract void ontvang(int aantalBallen);

    abstract void ballenNaarKalaha(int ballen);

    public abstract boolean eindeChecker();

    abstract int allesNaarKalaha(int aantalBallen);
    abstract int allesNaarKalaha();

}
