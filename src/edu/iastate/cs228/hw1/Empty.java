package edu.iastate.cs228.hw1;

public class Empty extends TownCell{
    public Empty(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.EMPTY;
    }

    @Override
    public TownCell next(Town tNew) {

        int[] nCensus = new int[5];
        census(nCensus);
        TownCell result;

        if(nCensus[OUTAGE] + nCensus[EMPTY] <= 1){
            result = new Reseller(tNew,row,col);
        } else {
            result = new Casual(tNew,row,col);
        }

        return result;
    }
}
