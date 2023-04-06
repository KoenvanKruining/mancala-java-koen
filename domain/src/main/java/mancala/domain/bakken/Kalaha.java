package mancala.domain.bakken;

import mancala.domain.Eigenaar;

public class Kalaha extends Bak{

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

    public boolean eindeChecker() {return true;}
    public uitkomst bepaalWinnaar(){
        if(eigenaar.isEigenaarAanDeBeurt()) {
            int eindstandTegenstander = buurBak.allesNaarKalaha();
            eigenaar.beeindigSpel();

            if (ballen > eindstandTegenstander) return uitkomst.GEWONNEN;
            if (ballen == eindstandTegenstander) return uitkomst.GELIJK;
            else return uitkomst.VERLOREN;
            } else return inverteerWinnaar(buurBak.bepaalWinnaar());
    }
    int allesNaarKalaha(int aantalBallen){
        ballen+=aantalBallen;
        return ballen;
    }
    int allesNaarKalaha(){return allesNaarKalaha(0);}
}