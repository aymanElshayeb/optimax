package de.optimaxenergy.aufgabe.bidder;

public interface Bidder {
    double getProposedBidCash(double lastBid, double lastCompatitorBid);
    void addQuanityAndDecreaseCash(int quantity, double cash);
    void printStatus();
    int getQuantity();
    double getCash();
}
