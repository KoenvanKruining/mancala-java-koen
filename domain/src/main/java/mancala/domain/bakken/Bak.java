package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public abstract class Bak {
    public enum uitkomst{SPELEND,GEWONNEN,VERLOREN,GELIJK}
    int ballen;
    Bak buurBak;
    public final Eigenaar eigenaar;

    public Bak(Eigenaar eigenaar){this.eigenaar=eigenaar;}
    public void setBuurbak(Bak buur){buurBak=buur;}

    public int vraagAantalBallenOp(){return ballen;}

    abstract void ontvang(int aantalBallen);

    abstract boolean eindeChecker();

    uitkomst inverteerWinnaar(uitkomst buuruitkomst){
        return switch (buuruitkomst) {
            case VERLOREN:
                yield uitkomst.GEWONNEN;
            case GEWONNEN:
                yield uitkomst.VERLOREN;
            case GELIJK:
                yield uitkomst.GELIJK;
            case SPELEND:
                yield uitkomst.SPELEND;
        };

    }

    abstract int allesNaarKalaha();
    abstract int allesNaarKalaha(int aantalBallen);

}
