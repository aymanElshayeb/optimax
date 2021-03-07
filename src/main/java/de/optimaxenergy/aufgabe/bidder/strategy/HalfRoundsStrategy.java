package de.optimaxenergy.aufgabe.bidder.strategy;

/**
 * This class implements HalfRounds Strategy, the algorithm targets the half of the bids and make use of
 * the wasting money from competitor to win more bidds
 */
public class HalfRoundsStrategy implements BidStrategy {

    private final int numberOfBids;
    private final double cashLimit;
    private double currentBidCash;
    private double compatitorCurrentCash;
    private int compatitorWinningBid;

    public HalfRoundsStrategy(double cashLimit, int numberOfBids) {
        this.currentBidCash = 2 * cashLimit / numberOfBids;
        this.cashLimit = cashLimit;
        this.compatitorCurrentCash = cashLimit;
        this.compatitorWinningBid = 0;
        this.numberOfBids = numberOfBids;
    }

    @Override
    public double getProposedBidCash(double lastBid, double lastCompatitorBid) {
        //compatitorCurrentCash is equals small value  means competitor loses his money and we can now bid with least cash
        if (compatitorCurrentCash < 0.1d) {
            return 0.1d;
        }
        if (lastCompatitorBid >= lastBid) {
            int halfOfBids = this.numberOfBids / 2;
            this.compatitorWinningBid++;
            this.compatitorCurrentCash -= lastCompatitorBid;
            if (this.compatitorWinningBid < halfOfBids) {
                this.currentBidCash = compatitorCurrentCash / (halfOfBids - this.compatitorWinningBid);
            }
        }

        return this.currentBidCash;
    }

}
