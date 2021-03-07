package de.optimaxenergy.aufgabe.controller;


import de.optimaxenergy.aufgabe.bidder.Bidder;

/**
 * This Class responsible to run the bid scenario. the scenario starts with 2 products to bid then
 * bidder bid by cash and the bidder with greater cash wins the bid then next 2 products is provided
 * to be bided
 */
public class BidController {
    private final Bidder bidder1;
    private final Bidder bidder2;
    private final int quantity;

    public BidController(Bidder bidder1, Bidder bidder2, int initialQuantity) {
        this.bidder1 = bidder1;
        this.bidder2 = bidder2;
        this.quantity = initialQuantity;
    }

    /**
     * main method to run the controller
     */
    public void run() {
        // negative value for first round
        double bidderCash1 = -1;
        double bidderCash2 = -1;
        int bid = 0;
        int remain = quantity;
        while (remain > 0) {
            bid++;
            // first line will change bidderCash1 so the old value should be stored in Temp value
            double bidderCash1Temp = bidderCash1;
            bidderCash1 = this.bidder1.getProposedBidCash(bidderCash1, bidderCash2);
            bidderCash2 = this.bidder2.getProposedBidCash(bidderCash2, bidderCash1Temp);
            System.out.println(" bid  = " + bid + " bidderCash1 " + bidderCash1 + " bidderCash2 " + bidderCash2);
            remain = judgeAndCalculateRemain(bidderCash1, bidderCash2, remain);
        }

    }

    /**
     * determines the winner and reduce the quantity of the product in Controller and notify the winner bidder to
     * modifiy its state
     *
     * @param bidderCash1
     * @param bidderCash2
     * @param remain
     * @return
     */
    private int judgeAndCalculateRemain(double bidderCash1, double bidderCash2, int remain) {
        remain -= 2;
        if (bidderCash1 > bidderCash2) {
            if (remain >= 0) {
                this.bidder1.addQuanityAndDecreaseCash(2, bidderCash1);
            }
            return remain;
        } else if (bidderCash1 < bidderCash2) {
            if (remain >= 0) {
                this.bidder2.addQuanityAndDecreaseCash(2, bidderCash2);
            }
            return remain;
        } else {
            //equal case
            if (remain >= 0) {
                this.bidder1.addQuanityAndDecreaseCash(1, bidderCash1);
                this.bidder2.addQuanityAndDecreaseCash(1, bidderCash2);
            }
            return remain;
        }
    }
}
