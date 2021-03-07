package de.optimaxenergy.aufgabe.bidder;

/**
 * Bidder interface contains main methods to get the proposed Bid cash and modify the case and gained product
 * quantity.
 */
public interface Bidder {
    /**
     * return the proposed Bid Cash according to used algorithm
     *
     * @param lastBid
     * @param lastCompatitorBid
     * @return
     */
    double getProposedBidCash(double lastBid, double lastCompatitorBid);

    /**
     * add product quantity and decrease the cash
     *
     * @param quantity
     * @param cash
     */
    void addQuanityAndDecreaseCash(int quantity, double cash);

    void printStatus();

    int getQuantity();

    double getCash();
}
