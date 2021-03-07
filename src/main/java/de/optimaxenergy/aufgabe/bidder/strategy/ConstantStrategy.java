package de.optimaxenergy.aufgabe.bidder.strategy;

/**
 * Constant strategy allows return back constant number until the end of chash.
 * if compatitor cash is ended up , the returned bid will be minimum
 */
public class ConstantStrategy implements BidStrategy {

    private final double averagePrice;

    public ConstantStrategy(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public double getProposedBidCash(double lastBid, double lastCompatitorBid) {
        //lastCompatitorBid == 0 means compatitor loses his money and we can now bid with least cash
        if (lastCompatitorBid == 0) {
            return 0.1d;
        }
        return this.averagePrice;
    }

}
