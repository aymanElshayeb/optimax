package de.optimaxenergy.aufgabe.bidder.strategy;

public interface BidStrategy {

    double getProposedBidCash(double lastBid, double lastCompatitorBid);
}
