package de.optimaxenergy.aufgabe.bidder;

import de.optimaxenergy.aufgabe.bidder.strategy.BidStrategy;

/**
 * Factory responsible to create bidder
 */
public class BidderFactory {
    /**
     * return back bidder with initial Quantity and initial Money
     *
     * @param initialQuantity
     * @param initialMoney
     * @param bidStrategy
     * @return
     */
    public static Bidder getBidder(int initialQuantity, double initialMoney, BidStrategy bidStrategy) {
        return new DefaultBidder(initialQuantity, initialMoney, bidStrategy);
    }
}
