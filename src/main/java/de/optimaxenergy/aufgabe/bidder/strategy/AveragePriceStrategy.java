package de.optimaxenergy.aufgabe.bidder.strategy;

public class AveragePriceStrategy implements BidStrategy {

	private double averagePrice;

    public AveragePriceStrategy(double averagePrice) {
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
