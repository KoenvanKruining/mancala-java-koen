package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Put extends Bak{

    public Put(Eigenaar eigenaar){
        super(eigenaar);
        this.ballen=4;
    }

    public void doeZet(){
        buurBak.ontvang(ballen);
        ballen=0;
    }
}
