package edu.iastate.cs228.hw1;

public class Streamer extends TownCell {
    public Streamer(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.STREAMER;
    }

    @Override
    public TownCell next(Town town) {

        int[] nCensus = new int[5];

        census(nCensus);

        TownCell result;

        if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
            result = new Reseller(town, row, col);
        } else if (nCensus[RESELLER] > 0) {
            result = new Outage(town, row, col);
        } else if (nCensus[OUTAGE] > 0) {
            result = new Empty(town, row, col);
        } else {
            result = new Streamer(town, row, col);
        }

        return result;
    }

}
