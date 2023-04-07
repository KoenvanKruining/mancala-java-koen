package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Put extends Bak{
    private Put overbuurPut;

    public Put(Eigenaar eigenaar){
        super(eigenaar);
        ballen=4;
    }

    public void kiesOverbuurPut(Put overbuurput){
        this.overbuurPut=overbuurput;
        overbuurput.overbuurPut=this;
    }

    public void doeZet(){
        if(eigenaar.isEigenaarAanDeBeurt() && ballen>0) {
            int doortegevenballen=ballen;
            ballen=0;
            buurBak.ontvang(doortegevenballen);

            if(checkSpelStatus()) buurBak.bepaalWinnaar();
        }
    }
    void ontvang(int aantalBallen){
        ballen+=1;
        if(aantalBallen>1) buurBak.ontvang(aantalBallen-1);
        if(aantalBallen==1) {
            if(eigenaar.isEigenaarAanDeBeurt() && ballen==1) putjePlunderen();

            eigenaar.wisselBeurt();
        }
    }
    void ballenNaarKalaha(){
        buurBak.ballenNaarKalaha(ballen);
        ballen=0;
    }
    void ballenNaarKalaha(int aantalBallen) {buurBak.ballenNaarKalaha(aantalBallen);}

    private void putjePlunderen(){
        ballen+= overbuurPut.vraagAantalBallenOp();
        overbuurPut.ballen=0;
        ballenNaarKalaha();
    }

    private boolean checkSpelStatus(){
        if(eigenaar.isEigenaarAanDeBeurt()) return overbuurPut.isSpelVoorbij();
        else return buurBak.isSpelVoorbij();
    }

    boolean isSpelVoorbij(){return buurBak.isSpelVoorbij();}

    boolean eindeChecker() {return ballen==0 && buurBak.eindeChecker();}

    uitkomst bepaalWinnaar(){
        if(buurBak.eigenaar==eigenaar) return buurBak.bepaalWinnaar();
        else return inverteerWinnaar(buurBak.bepaalWinnaar());
    }

    int allesNaarKalaha(int aantalBallen){
        int doortegevenballen=ballen;
        ballen=0;
        return buurBak.allesNaarKalaha(doortegevenballen+aantalBallen);
    }
    int allesNaarKalaha(){
        return allesNaarKalaha(0);
    }
}
