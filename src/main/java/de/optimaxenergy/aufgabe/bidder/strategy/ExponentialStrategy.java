package de.optimaxenergy.aufgabe.bidder.strategy;

public class ExponentialStrategy implements BidStrategy {

    private final double baseStep;
    private double effectiveStep;

    public ExponentialStrategy(double baseStep) {
        this.baseStep = baseStep;
        this.effectiveStep = baseStep;
    }

    @Override
    public double getProposedBidCash(double lastBid, double lastCompatitorBid) {
        //lastBid< 0 means we should return initial value
        if (lastBid < 0) {
            return this.baseStep;
        }
        // if bidder loses last bid increase the step
        if (lastCompatitorBid >= lastBid) {
            this.effectiveStep = this.effectiveStep + baseStep;
            return lastCompatitorBid + this.effectiveStep;
        }
        return lastBid + this.effectiveStep;
    }

}
