package de.optimaxenergy.aufgabe.bidder.strategy;

public class IncreamentalWithStepStrategy implements BidStrategy {

    private final double baseStep;
    private double effectiveStep;

    public IncreamentalWithStepStrategy(double baseStep) {
        this.baseStep = baseStep;
        this.effectiveStep = baseStep;
    }

    @Override
    public double getProposedBidCash(double lastBid, double lastCompatitorBid) {
        //lastBid< 0 means we should return initial value
        if (lastBid < 0) {
            return this.baseStep;
        }
        //lastCompatitorBid == 0 means compatitor loses his money and we can now bid with least cash
        if (lastCompatitorBid == 0) {
            return 0.1d;
        }
        
        // if bidder loses last bid increase the step
        if (lastCompatitorBid >= lastBid) {
            this.effectiveStep = this.effectiveStep + baseStep;
            return lastCompatitorBid + this.effectiveStep;
        }
        // reset the effectiveStep to basestep because this bidder wins the last bid
        //this.effectiveStep = this.baseStep;
        return lastBid + this.effectiveStep;
    }

}
