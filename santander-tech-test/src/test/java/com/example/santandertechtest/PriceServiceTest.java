package com.example.santandertechtest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriceServiceTest {

   PriceService priceService = new PriceService();

    //    Validate each price to ensure that bid < ask and that the commission has been applied correctly
    @Test
    public void latestPrice_eurUsd_bidPriceShouldBeLessThanAskPrice_Pass(){
        Price eurToUsd = new Price(106, "EUR/USD", 1.1000, 1.2000, "01-06-2020 12:01:01:001");

        Price latestPrice = priceService.latestPriceWithCommission(eurToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertTrue(latestPriceBid < latestPriceAsk);
    }

    @Test
    public void latestPrice_eurUsd_bidPriceShouldBeLessThanAskPrice_Fail(){
        Price eurToUsd = new Price(106, "EUR/USD", 1.1000, 1.2000, "01-06-2020 12:01:01:001");

        Price latestPrice = priceService.latestPriceWithCommission(eurToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertFalse(latestPriceBid > latestPriceAsk);
    }

    @Test
    public void latestPrice_eurJpy_bidPriceShouldBeLessThanAskPrice_Pass(){
        Price eurToJpy = new Price(107, "EUR/JPY", 119.60, 119.90,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(eurToJpy);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertTrue(latestPriceBid < latestPriceAsk);
    }

    @Test
    public void latestPrice_eurJpy_bidPriceShouldBeLessThanAskPrice_Fail(){
        Price eurToJpy = new Price(107, "EUR/JPY", 119.60, 119.90,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(eurToJpy);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertFalse(latestPriceBid > latestPriceAsk);
    }

    @Test
    public void latestPrice_gbpToUsd_bidPriceShouldBeLessThanAskPrice_Pass(){
        Price gbpToUsd = new Price(108, "GBP/USD", 1.2500, 1.2560,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(gbpToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertTrue(latestPriceBid < latestPriceAsk);
    }

    @Test
    public void latestPrice_gbpToUsd_bidPriceShouldBeLessThanAskPrice_Fail(){
        Price gbpToUsd = new Price(108, "GBP/USD", 1.2500, 1.2560,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(gbpToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertFalse(latestPriceBid > latestPriceAsk);
    }

    @Test
    public void latestPriceWithCommission_eurToUsd_commissionCorrect_Pass(){
        Price eurToUsd = new Price(106, "EUR/USD", 1.1000, 1.2000, "01-06-2020 12:01:01:001");

        Price latestPrice = priceService.latestPriceWithCommission(eurToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertTrue(latestPriceBid == 1.0989 && latestPriceAsk == 1.2012);
    }

    @Test
    public void latestPriceWithCommission_eurToUsd_commissionCorrect_Fail(){
        Price gbpToUsd = new Price(108, "GBP/USD", 1.2500, 1.2560,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(gbpToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertFalse(latestPriceAsk == 1.0999);
        assertFalse(latestPriceBid == 1.2019);
    }


    @Test
    public void latestPriceWithCommission_gbpToUsd_commissionIsCorrect_Pass(){
        Price gbpToUsd = new Price(108, "GBP/USD", 1.2500, 1.2560,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(gbpToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertTrue(latestPriceBid == 1.2488 && latestPriceAsk == 1.2573);
    }

    @Test
    public void latestPriceWithCommission_gbpToUsd_commissionIsCorrect_Fail(){
        Price gbpToUsd = new Price(108, "GBP/USD", 1.2500, 1.2560,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(gbpToUsd);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertFalse(latestPriceAsk == 1.2574);
        assertFalse(latestPriceBid == 1.2489);
    }


    @Test
    public void latestPriceWithCommission_eurToJpy_commissionIsCorrect_Pass(){
        Price eurToJpy = new Price(107, "EUR/JPY", 119.60, 119.90,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(eurToJpy);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertTrue(latestPriceBid == 119.4804 && latestPriceAsk == 120.0199);

    }

    @Test
    public void latestPriceWithCommission_eurToJpy_commissionIsCorrect_Fail(){
        Price eurToJpy = new Price(107, "EUR/JPY", 119.60, 119.90,"01-06-2020 12:01:02:002");

        Price latestPrice = priceService.latestPriceWithCommission(eurToJpy);
        double latestPriceBid = latestPrice.getBidPrice();
        double latestPriceAsk = latestPrice.getAskPrice();

        assertFalse(latestPriceAsk == 119.4804);
        assertFalse(latestPriceBid == 120.0199);
    }
}
