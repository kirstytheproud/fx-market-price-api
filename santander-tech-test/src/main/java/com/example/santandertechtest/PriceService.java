package com.example.santandertechtest;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    public List<Price> parseCSVtoPrice() {
        try {
            CSVReader reader =
                    new CSVReaderBuilder(new FileReader("C:\\Users\\user\\nology\\Santander\\santander-tech-test\\santander-tech-test\\src\\main\\java\\com\\example\\santandertechtest\\price_data.csv")).
                            withSkipLines(1). // Skipping first line as it is header
                            build();
            List<Price> priceList = reader.readAll().stream().map(data -> {
                Price price = new Price();
                price.setId(Integer.parseInt(data[0]));
                price.setInstrumentName(data[1]);
                price.setBidPrice(Double.parseDouble(data[2]));
                price.setAskPrice(Double.parseDouble(data[3]));
                price.setTimestamp(data[4]);
                return price;
            }).collect(Collectors.toList());
            return priceList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }

    // get recent price, adjust bid (-0.1%) and ask (+0.1%) prices with commission
    public Price latestPriceWithCommission(Price latestPrice){
        double bid = latestPrice.getBidPrice();
        double bidCommission = (double)Math.round((bid - (0.1/100 * bid))*10000)/10000;
        latestPrice.setBidPrice(bidCommission);

        double ask = latestPrice.getAskPrice();
        double askCommission = (double)Math.round((ask + (0.1/100 * ask))*10000)/10000;
        latestPrice.setAskPrice(askCommission);

        return latestPrice;
    }
}
