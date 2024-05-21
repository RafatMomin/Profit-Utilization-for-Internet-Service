package edu.iastate.cs228.hw1;

public class Casual extends TownCell {
    public Casual(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.CASUAL;
    }

    @Override
    public TownCell next(Town tNew) {

        int[] nCensus = new int[5];
        census(nCensus);
        TownCell result;

        if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
            result = new Reseller(tNew, row, col);
        } else if (nCensus[RESELLER] > 0) {
            result = new Outage(tNew, row, col);
        } else if (nCensus[STREAMER] > 0 || nCensus[CASUAL] >= 5) {
            result = new Streamer(tNew, row, col);
        } else {
            result = new Casual(tNew, row, col);
        }

        return result;
    }

}
