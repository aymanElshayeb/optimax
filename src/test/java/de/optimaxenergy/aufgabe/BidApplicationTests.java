package de.optimaxenergy.aufgabe;

import de.optimaxenergy.aufgabe.bidder.Bidder;
import de.optimaxenergy.aufgabe.bidder.BidderFactory;
import de.optimaxenergy.aufgabe.bidder.strategy.AveragePriceStrategy;
import de.optimaxenergy.aufgabe.bidder.strategy.IncreamentalAverageStrategy;
import de.optimaxenergy.aufgabe.bidder.strategy.IncreamentalWithStepStrategy;
import de.optimaxenergy.aufgabe.controller.BidController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class BidApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
//    void testBidderWithDifferentStep() {
//        Bidder bidder1 = BidderFactory.getBidder(0, 10000, new IncreamentalWithStepStrategy(3.2));
//        Bidder bidder2 = BidderFactory.getBidder(0, 10000, new IncreamentalWithStepStrategy(2.2));
//        BidController bidController = new BidController(bidder1, bidder2, 50);
//        bidController.run();
//        bidder1.printStatus();
//        bidder2.printStatus();
//        //Assert.isTrue(bidder1.getQuantity() == 10, "bidder1 winning quanity is incorrect");
//        //Assert.isTrue(bidder2.getQuantity() == 40, "bidder2 winning quanity is incorrect");
//    }

//    @Test
//    void testBidderWithSameStep() {
//        Bidder bidder1 = BidderFactory.getBidder(0, 10000, new IncreamentalWithStepStrategy(2.3));
//        Bidder bidder2 = BidderFactory.getBidder(0, 10000, new IncreamentalWithStepStrategy(2.3));
//        BidController bidController = new BidController(bidder1, bidder2, 50);
//        bidController.run();
//        bidder1.printStatus();
//        bidder2.printStatus();
//        //Assert.isTrue(bidder1.getQuantity() == 7, "bidder1 winning quanity is incorrect");
//        //Assert.isTrue(bidder2.getQuantity() == 43, "bidder2 winning quanity is incorrect");
//    }
    
//    @Test
//    void testAveragePriceVsIncrementalBidders() {
//        Bidder bidder1 = BidderFactory.getBidder(0, 10000, new IncreamentalWithStepStrategy(1.2));
//        Bidder bidder2 = BidderFactory.getBidder(0, 10000, new AveragePriceStrategy(10000/50));
//        BidController bidController = new BidController(bidder1, bidder2, 50);
//        bidController.run();
//        bidder1.printStatus();
//        bidder2.printStatus();
//        //Assert.isTrue(bidder1.getQuantity() == 7, "bidder1 winning quanity is incorrect");
//        //Assert.isTrue(bidder2.getQuantity() == 43, "bidder2 winning quanity is incorrect");
//    }

    @Test
    void testIncreamentalAverageVsIncrementalBidders() {
    	double cashLimit = 100000;
    	int productNumber = 2000;
    	double average = cashLimit /productNumber ;
    	int numberOfbid = Math.round(productNumber/2);
        Bidder bidder1 = BidderFactory.getBidder(0, cashLimit, new AveragePriceStrategy(2*(cashLimit/numberOfbid) * 0.99));
        Bidder bidder2 = BidderFactory.getBidder(0, cashLimit, new IncreamentalAverageStrategy(cashLimit, numberOfbid));
        BidController bidController = new BidController(bidder1, bidder2, productNumber);
        bidController.run();
        bidder1.printStatus();
        bidder2.printStatus();
        //Assert.isTrue(bidder1.getQuantity() == 7, "bidder1 winning quanity is incorrect");
        //Assert.isTrue(bidder2.getQuantity() == 43, "bidder2 winning quanity is incorrect");
    }
//    @Test
//    void testIncreamentalAverageVsIncrementalBidders() {
//    	double cashLimit = 100000;
//    	int productNumber = 2000;
//    	double average = cashLimit /productNumber ;
//    	int numberOfbid = Math.round(productNumber/2);
//    	Bidder bidder1 = BidderFactory.getBidder(0, cashLimit, new IncreamentalWithStepStrategy(0.00001));
//        Bidder bidder2 = BidderFactory.getBidder(0, cashLimit, new AveragePriceStrategy(2*(cashLimit/numberOfbid)+0.000001));
//        BidController bidController = new BidController(bidder1, bidder2, productNumber);
//        bidController.run();
//        bidder1.printStatus();
//        bidder2.printStatus();
//        //Assert.isTrue(bidder1.getQuantity() == 7, "bidder1 winning quanity is incorrect");
//        //Assert.isTrue(bidder2.getQuantity() == 43, "bidder2 winning quanity is incorrect");
//    }
}
