package mancala.domain.bakken;

public abstract class Bak {
    protected int ballen;
    protected Bak buurBak;

    public int vraagAantalBallenOp(){
        return ballen;
    }
}
