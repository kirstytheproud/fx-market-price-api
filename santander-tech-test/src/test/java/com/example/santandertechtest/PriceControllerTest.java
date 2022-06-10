package com.example.santandertechtest;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceControllerTest {

    PriceController priceController = new PriceController();

    // Test that prices are being processed in sequence and none are missing
    @Test
    public void getAllPrices_processedInSequence_priceIdOfIndex0_ReturnsId106(){
       List<Price> allPrices = priceController.getAllPrices();
        Price priceByIndex = allPrices.get(0);
        int id = priceByIndex.getId();

        assertEquals(id, 106);
    }

    @Test
    public void getAllPrices_processedInSequence_priceIdOfIndex1_ReturnsId107(){
        List<Price> allPrices = priceController.getAllPrices();
        Price priceByIndex = allPrices.get(1);
        int id = priceByIndex.getId();

        assertEquals(id, 107);
    }

    @Test
    public void getAllPrices_processedInSequence_priceIdOfIndex2_ReturnsId108(){
        List<Price> allPrices = priceController.getAllPrices();
        Price priceByIndex = allPrices.get(2);
        int id = priceByIndex.getId();

        assertEquals(id, 108);
    }

    @Test
    public void getAllPrices_processedInSequence_priceIdOfIndex3_ReturnsId109(){
        List<Price> allPrices = priceController.getAllPrices();
        Price priceByIndex = allPrices.get(3);
        int id = priceByIndex.getId();

        assertEquals(id, 109);
    }

    @Test
    public void getAllPrices_processedInSequence_priceIdOfIndex4_ReturnsId110(){
        List<Price> allPrices = priceController.getAllPrices();
        Price priceByIndex = allPrices.get(4);
        int id = priceByIndex.getId();

        assertEquals(id, 110);
    }

    //    Test for only the latest price for a given instrument is stored (client should not be able to see older prices)
    @Test
    public void latestPrice_EURUSD_ReturnsOnlyMostRecentPrice_Pass(){
        int eurToJpyLatestId = (priceController.latestPrice("EUR/JPY")).getId();

        assertEquals(eurToJpyLatestId, 110);
    }

    @Test
    public void latestPrice_GBPUSD_ReturnsOnlyMostRecentPrice_Pass(){
        int gbpToUsdLatestId = (priceController.latestPrice("GBP/USD")).getId();

        assertEquals(gbpToUsdLatestId, 109);
    }
}
