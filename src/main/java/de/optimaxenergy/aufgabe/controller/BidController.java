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
        int bid = 0;
        int remain = quantity;
        while(remain>0) {
        	bid++;
            bidderCash1 = this.bidder1.getProposedBidCash(bidderCash1, bidderCash2);
            bidderCash2 = this.bidder2.getProposedBidCash(bidderCash2, bidderCash1);
            System.out.println(" bid  = " + bid + " bidderCash1 " + bidderCash1 + " bidderCash2 " + bidderCash2);
            remain= judgeAndGetRemain(bidderCash1, bidderCash2,remain);
        }

    }

    private int  judgeAndGetRemain(double bidderCash1, double bidderCash2, int remain) {
        if (bidderCash1 > bidderCash2) {
        	remain -=2;
        	if(remain>=0) {
        		this.bidder1.addQuanityAndDecreaseCash(2, bidderCash1);
        	}
            return remain;
        } else if (bidderCash1 < bidderCash2) {
        	remain -=2;
        	if(remain>=0) {
        		this.bidder2.addQuanityAndDecreaseCash(2, bidderCash1);
        	}
            return remain;
        } else {
            //equal case
        	remain -=1;
        	if(remain>=0) {
        		this.bidder1.addQuanityAndDecreaseCash(1, bidderCash1);
        		this.bidder1.addQuanityAndDecreaseCash(1, bidderCash2);
        	}
            return remain;
        }
    }
}
