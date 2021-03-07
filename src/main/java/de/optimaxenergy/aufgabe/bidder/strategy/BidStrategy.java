package de.optimaxenergy.aufgabe.bidder.strategy;

/**
 * Main Strategy interface
 */
public interface BidStrategy {

    double getProposedBidCash(double lastBid, double lastCompatitorBid);
}
