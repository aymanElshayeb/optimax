package de.optimaxenergy.aufgabe.bidder.strategy;

/**
 * This class starts with base value to bid then this value increased each time bidder fails to win.
 */
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

        // if compatitor wins increase the step to win the value
        if (lastCompatitorBid >= lastBid) {
            this.effectiveStep = this.effectiveStep + baseStep;
            return lastCompatitorBid + this.effectiveStep;
        }

        return lastBid + this.effectiveStep;
    }

}
