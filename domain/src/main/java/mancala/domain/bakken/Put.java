package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Put extends Bak{
    private Put overbuurPut;
    private Put startPut;
    private Kalaha kalaha;

    public Put(Eigenaar eigenaar){
        super(eigenaar);
        ballen=4;
    }

    public void kiesOverbuurPut(Put overbuurput){
        this.overbuurPut=overbuurput;
        overbuurput.kiesOverbuurputOok(this);
    }

    void kiesOverbuurputOok(Put overbuurput){overbuurPut=overbuurput;}

    public void kiesStartPut(Put startput){startPut=startput;}
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
    void ballenNaarKalaha(){
        buurBak.ballenNaarKalaha(ballen);
        ballen=0;
    }
    void ballenNaarKalaha(int aantalBallen) {buurBak.ballenNaarKalaha(aantalBallen);}

    void putjePlunderen(){
        ballen+= overbuurPut.vraagAantalBallenOp();
        overbuurPut.ballen=0;
        ballenNaarKalaha();
    }

    private boolean statusChecker(){
        if(eigenaar.isEigenaarAanDeBeurt()) return startPut.eindeChecker();
        else return overbuurPut.startPut.eindeChecker();
    }

    public boolean eindeChecker() {return ballen==0 && buurBak.eindeChecker();}


    int allesNaarKalaha(int aantalBallen){
        int doortegevenballen=ballen;
        ballen=0;
        return buurBak.allesNaarKalaha(doortegevenballen+aantalBallen);
    }
    int allesNaarKalaha(){
        return allesNaarKalaha(0);
    }
}
