package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Put extends Bak{
    private Put overbuurPut;
    private final Put startPut;
    private Kalaha kalaha;

    public Put(Eigenaar eigenaar,int aantalballenperput,Put startput){
        super(eigenaar);
        ballen=aantalballenperput;
        if(startput==null) startPut=this;
        else startPut=startput;
    }

    public Put(Eigenaar eigenaar,Put startput){
        super(eigenaar);
        ballen=4;
        if(startput==null) startPut=this;
        else startPut=startput;
    }
    public Put(Eigenaar eigenaar){
        super(eigenaar);
        ballen=4;
        startPut=this;
    }

    public void kiesOverbuurPut(Put overbuurput){
        this.overbuurPut=overbuurput;
        overbuurput.overbuurPut=this;
    }

    public void kiesKalaha(Kalaha eigenKalaha){kalaha=eigenKalaha;}

    public void doeZet(){
        if(eigenaar.isEigenaarAanDeBeurt() && ballen>0) {
            int doortegevenballen=ballen;
            ballen=0;
            buurBak.ontvang(doortegevenballen);

            if(statusChecker()) {
                if(eigenaar.isEigenaarAanDeBeurt()) kalaha.bepaalWinnaar();
                else {
                    inverteerWinnaar(overbuurPut.kalaha.bepaalWinnaar());
                }
            }
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

    private void putjePlunderen(){
        ballen+= overbuurPut.vraagAantalBallenOp();
        overbuurPut.ballen=0;
        kalaha.ballen+=ballen;
        ballen=0;
    }

    private boolean statusChecker(){
        if(eigenaar.isEigenaarAanDeBeurt()) return startPut.eindeChecker();
        else return overbuurPut.startPut.eindeChecker();
    }

    boolean eindeChecker() {return ballen==0 && buurBak.eindeChecker();}


    int allesNaarKalaha(int aantalBallen){
        int doortegevenballen=ballen;
        ballen=0;
        return buurBak.allesNaarKalaha(doortegevenballen+aantalBallen);
    }
    int allesNaarKalaha(){return allesNaarKalaha(0);}
}
