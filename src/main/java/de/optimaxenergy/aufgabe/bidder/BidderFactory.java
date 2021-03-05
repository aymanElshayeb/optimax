package de.optimaxenergy.aufgabe.bidder;

import de.optimaxenergy.aufgabe.bidder.strategy.BidStrategy;

public class BidderFactory {
    public static Bidder getBidder( int initialQuantity, double initialMoney, BidStrategy bidStrategy) {
        return new DefaultBidder( initialQuantity, initialMoney, bidStrategy);
    }
}
