package de.optimaxenergy.aufgabe.bidder;

import de.optimaxenergy.aufgabe.bidder.strategy.BidStrategy;

/**
 * This class contains the main implementation of the bidder
 */
public class DefaultBidder implements Bidder {
    private final BidStrategy bidStrategy;
    private int quantity;
    private double currentCash;

    public DefaultBidder(int initialQuantity,
                         double intialCash, BidStrategy bidStrategy) {
        this.quantity = initialQuantity;
        this.currentCash = intialCash;
        this.bidStrategy = bidStrategy;
    }

    public double getProposedBidCash(double lastBid, double lastCompatitorBid) {
        double proposedBidCash = bidStrategy.getProposedBidCash(lastBid, lastCompatitorBid);
        //bound the propsedBidMoney to cash limit
        return bound(proposedBidCash);
    }

    private double bound(double proposedBidCash) {
        if (proposedBidCash > this.currentCash) {
            return this.currentCash;
        }
        return proposedBidCash;
    }

    public void addQuanityAndDecreaseCash(int quantity, double cash) {
        this.quantity += quantity;
        this.currentCash -= cash;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getCash() {
        return this.currentCash;
    }

    public void printStatus() {
        System.out.println("Wining Quanity = " + this.quantity);
        System.out.println("Remaining Money = " + this.currentCash);

    }
}
