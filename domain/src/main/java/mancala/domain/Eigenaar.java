package mancala.domain;

public class Eigenaar {
    private boolean aanDeBeurt;

    public Eigenaar(boolean beginBeurt){this.aanDeBeurt=beginBeurt;}

    public boolean isEigenaarAanDeBeurt(){return aanDeBeurt;}
}