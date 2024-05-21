package edu.iastate.cs228.hw1;

public class Reseller extends TownCell {

    public Reseller(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town town) {

        int[] nCensus = new int[5];
        census(nCensus);
        TownCell result;

        if (nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3) {
            result = new Empty(town, row, col);
        } else if (nCensus[CASUAL] >= 5) {
            result = new Streamer(town, row, col);
        } else {
            result = new Reseller(town, row, col);
        }

        return result;
    }

}
