package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Kalaha extends Bak{
    public Kalaha(Eigenaar eigenaar) {
        super(eigenaar);
    }

    protected void ontvang(int aantalBallen){
        if(this.eigenaar.isEigenaarAanDeBeurt()) {
            this.ballen += 1;
            if (aantalBallen > 1) buurBak.ontvang(aantalBallen - 1);
        } else buurBak.ontvang(aantalBallen);
    }
}