package mancala.domain.bakken;

public abstract class Bak {
    protected int ballen;
    public Bak buurBak;

    public int vraagAantalBallenOp(){
        return ballen;
    }

    protected void ontvang(int aantalBallen){
        this.ballen+=1;
        if(aantalBallen>1)  buurBak.ontvang(aantalBallen-1);
    }
}
