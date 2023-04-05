package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Kalaha extends Bak{

    enum speluitkomst{GEWONNEN,VERLOREN,GELIJK}
    public Kalaha(Eigenaar eigenaar) {
        super(eigenaar);
    }

    void ontvang(int aantalBallen){
        if(eigenaar.isEigenaarAanDeBeurt()) {
            ballen += 1;
            if (aantalBallen > 1) buurBak.ontvang(aantalBallen - 1);
        } else buurBak.ontvang(aantalBallen);
    }


    void ballenNaarKalaha(int aantalBallen) {ballen+=aantalBallen;}

    boolean eindeChecker() {
        return true;
    }
    public speluitkomst bepaalWinnaar(){
        int eindstandTegenstander=buurBak.allesNaarKalaha();
        if(ballen>eindstandTegenstander) return speluitkomst.GEWONNEN;
        if(ballen==eindstandTegenstander) return speluitkomst.GELIJK;
        else return speluitkomst.VERLOREN;
    }
    int allesNaarKalaha(int aantalBallen){
        ballen+=aantalBallen;
        return ballen;
    }
    int allesNaarKalaha(){return allesNaarKalaha(0);}
}