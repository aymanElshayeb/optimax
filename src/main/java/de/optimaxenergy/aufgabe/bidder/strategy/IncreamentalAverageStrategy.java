package de.optimaxenergy.aufgabe.bidder.strategy;

public class IncreamentalAverageStrategy implements BidStrategy {

	private double step;
	

    public IncreamentalAverageStrategy(double cashLimit, int numberOfBids) {
    	this.step =2*cashLimit / numberOfBids;
    }

    @Override
    public double getProposedBidCash(double lastBid, double lastCompatitorBid) {
    	//lastCompatitorBid == 0 means compatitor loses his money and we can now bid with least cash
        double temp = 0;
    	if (lastCompatitorBid == 0) {
            return 0.1d;
        }
        if(lastBid> lastCompatitorBid) {
       
        } else if (lastBid == lastCompatitorBid){
        	this.step *= 1.0001;        	
        } else {
        	temp = lastBid;
        }
//       	System.out.println("lastBid = " + lastBid + " lastCompatitorBid = " + lastCompatitorBid +
//        " savingCash " +savingCash + " step "+step 
//        + " returned value  " + (this.savingCash + this.step)  );
        return temp + this.step;
    }

}
