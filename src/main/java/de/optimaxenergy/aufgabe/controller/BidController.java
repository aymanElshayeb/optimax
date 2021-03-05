package de.optimaxenergy.aufgabe.controller;


import de.optimaxenergy.aufgabe.bidder.Bidder;

public class BidController {
    private final Bidder bidder1;
    private final Bidder bidder2;
    private final int quantity;

    public BidController(Bidder bidder1, Bidder bidder2, int initialQuantity) {
        this.bidder1 = bidder1;
        this.bidder2 = bidder2;
        this.quantity = initialQuantity;
    }

    public void run() {
        double bidderCash1 = -1;
        double bidderCash2 = -1;
        for (int i = 0; i < quantity; i += 2) {
            bidderCash1 = this.bidder1.getProposedBidCash(bidderCash1, bidderCash2);
            bidderCash2 = this.bidder2.getProposedBidCash(bidderCash2, bidderCash1);
            System.out.println(" bid  = " + i + " bidderCash1 " + bidderCash1 + " bidderCash2 " + bidderCash2);
            judge(bidderCash1, bidderCash2);
        }

    }

    private void judge(double bidderCash1, double bidderCash2) {
        if (bidderCash1 > bidderCash2) {
            this.bidder1.addQuanityAndDecreaseCash(2, bidderCash1);
        } else if (bidderCash1 < bidderCash2) {
            this.bidder2.addQuanityAndDecreaseCash(2, bidderCash2);
        } else {
            //equal case
            this.bidder1.addQuanityAndDecreaseCash(1, bidderCash1);
            this.bidder2.addQuanityAndDecreaseCash(1, bidderCash2);
        }
    }
}
