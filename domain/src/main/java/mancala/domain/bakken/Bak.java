package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public abstract class Bak {
    enum uitkomst{GEWONNEN,VERLOREN,GELIJK}
    int ballen;
    Bak buurBak;
    final Eigenaar eigenaar;

    public Bak(Eigenaar eigenaar){this.eigenaar=eigenaar;}
    public void setBuurbak(Bak buur){buurBak=buur;}

    public int vraagAantalBallenOp(){return ballen;}

    abstract void ontvang(int aantalBallen);

    abstract void ballenNaarKalaha(int ballen);

    abstract boolean isSpelVoorbij();

    abstract boolean eindeChecker();

    abstract uitkomst bepaalWinnaar();

    uitkomst inverteerWinnaar(uitkomst buuruitkomst){
        return switch (buuruitkomst) {
            case VERLOREN:
                yield uitkomst.GEWONNEN;
            case GEWONNEN:
                yield uitkomst.VERLOREN;
            case GELIJK:
                yield uitkomst.GELIJK;
        };
    }

    abstract int allesNaarKalaha();
    abstract int allesNaarKalaha(int aantalBallen);

}
