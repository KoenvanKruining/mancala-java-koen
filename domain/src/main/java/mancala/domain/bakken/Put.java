package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Put extends Bak{
    private Put overbuurPut;

    public Put(Eigenaar eigenaar){
        super(eigenaar);
        this.ballen=4;
    }

    public void kiesOverbuurPut(Put overbuurput){
        this.overbuurPut=overbuurput;
        overbuurput.kiesOverbuurputOok(this);
    }

    void kiesOverbuurputOok(Put overbuurput){this.overbuurPut=overbuurput;}

    public void doeZet(){
        if(eigenaar.isEigenaarAanDeBeurt() && ballen>0) {
            int doortegevenballen=ballen;
            ballen=0;
            buurBak.ontvang(doortegevenballen);

        }
    }
    void ontvang(int aantalBallen){
        this.ballen+=1;
        if(aantalBallen>1) buurBak.ontvang(aantalBallen-1);
        if(aantalBallen==1) {
            if(eigenaar.isEigenaarAanDeBeurt() && this.ballen==1) {
                this.ballen+= overbuurPut.vraagAantalBallenOp();
                overbuurPut.putjePlunderen();
                ballenNaarKalaha();
            }
            eigenaar.wisselBeurt();
        }
    }
    void ballenNaarKalaha(){
        buurBak.ballenNaarKalaha(this.ballen);
        this.ballen=0;
    }
    void ballenNaarKalaha(int aantalBallen) {buurBak.ballenNaarKalaha(aantalBallen);}

    void putjePlunderen(){this.ballen=0;}

    boolean eindeChecker() {
        if(this.ballen >0) return false;
        else return buurBak.eindeChecker();
    }

    void allesNaarKalaha(int aantalBallen){
        buurBak.allesNaarKalaha(ballen+aantalBallen);
        ballen=0;
    }
    void allesNaarKalaha(){
        allesNaarKalaha(0);
    }
}
