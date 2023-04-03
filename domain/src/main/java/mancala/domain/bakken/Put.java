package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Put extends Bak{
    private Put overbuurBak;

    public Put(Eigenaar eigenaar){
        super(eigenaar);
        this.ballen=4;
    }

    public void doeZet(){
        if(eigenaar.isEigenaarAanDeBeurt() && ballen>0) {
            buurBak.ontvang(ballen);
            ballen=0;
        }
    }
}
