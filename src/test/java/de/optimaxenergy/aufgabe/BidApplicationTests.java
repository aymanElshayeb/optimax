package de.optimaxenergy.aufgabe;

import de.optimaxenergy.aufgabe.bidder.Bidder;
import de.optimaxenergy.aufgabe.bidder.BidderFactory;
import de.optimaxenergy.aufgabe.bidder.strategy.ConstantStrategy;
import de.optimaxenergy.aufgabe.bidder.strategy.HalfRoundsStrategy;
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

    @Test
    void testHalfRoundVsConstantBidders() {
        double cashLimit = 100000;
        int productNumber = 2000;
        int numberOfbid = Math.round(productNumber / 2);
        Bidder bidder1 = BidderFactory.getBidder(0, cashLimit, new HalfRoundsStrategy(cashLimit, numberOfbid));
        Bidder bidder2 = BidderFactory.getBidder(0, cashLimit, new ConstantStrategy(3 * (cashLimit / numberOfbid)));
        BidController bidController = new BidController(bidder1, bidder2, productNumber);
        bidController.run();
        bidder1.printStatus();
        bidder2.printStatus();
        Assert.isTrue(bidder1.getQuantity() == 1332, "bidder1 with HalfRoundsStrategy product quantity is incorrect");
        Assert.isTrue(bidder2.getQuantity() == 668, "bidder2 with ConstantStrategy product quantity is incorrect");
    }

    @Test
    void testHalfRoundsVsIncrementalWithStepBidders() {
        double cashLimit = 100000;
        int productNumber = 2000;
        int numberOfbid = Math.round(productNumber / 2);
        Bidder bidder1 = BidderFactory.getBidder(0, cashLimit, new HalfRoundsStrategy(cashLimit, numberOfbid));
        Bidder bidder2 = BidderFactory.getBidder(0, cashLimit, new IncreamentalWithStepStrategy(1.2));
        BidController bidController = new BidController(bidder1, bidder2, productNumber);
        bidController.run();
        bidder1.printStatus();
        bidder2.printStatus();
        Assert.isTrue(bidder1.getQuantity() == 1566, "bidder1 with HalfRoundsStrategy product quantity is incorrect");
        Assert.isTrue(bidder2.getQuantity() == 434, "bidder2 with ConstantStrategy product quantity is incorrect");
    }
}
