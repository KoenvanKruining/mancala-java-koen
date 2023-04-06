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
        overbuurput.kiesOverbuurputOok(this);
    }

    void kiesOverbuurputOok(Put overbuurput){overbuurPut=overbuurput;}

    public void doeZet(){
        if(eigenaar.isEigenaarAanDeBeurt() && ballen>0) {
            int doortegevenballen=ballen;
            ballen=0;
            buurBak.ontvang(doortegevenballen);

            try{
                if(eigenaar.isSpelVoorbij()) buurBak.bepaalWinnaar();
            } catch (NullPointerException e){}
        }
    }
    void ontvang(int aantalBallen){
        ballen+=1;
        if(aantalBallen>1) buurBak.ontvang(aantalBallen-1);
        if(aantalBallen==1) {
            if(eigenaar.isEigenaarAanDeBeurt() && ballen==1) {
                ballen+= overbuurPut.vraagAantalBallenOp();
                overbuurPut.putjePlunderen();
                ballenNaarKalaha();
            }
            eigenaar.wisselBeurt();
        }
    }
    void ballenNaarKalaha(){
        buurBak.ballenNaarKalaha(ballen);
        ballen=0;
    }
    void ballenNaarKalaha(int aantalBallen) {buurBak.ballenNaarKalaha(aantalBallen);}

    void putjePlunderen(){ballen=0;}

    public boolean eindeChecker() {
        if(this.ballen >0) return false;
        else return buurBak.eindeChecker();
    }

    public uitkomst bepaalWinnaar(){
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
