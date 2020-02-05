package ua.kiev.prog.retrievers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.kiev.prog.dto.ExchangeRateDTO;
import ua.kiev.prog.json.Rate;

@Component
public class RateRetriever {

    private static final String URL = "http://data.fixer.io/api/latest?access_key=30e7ff0de73cf99ac8842101abce80ca";


    @Cacheable("rates")
    public Rate getRate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rate> response = restTemplate.getForEntity(URL, Rate.class);
        return response.getBody();
    }


    public ExchangeRateDTO getExchangeRate(String rate){

        ExchangeRateDTO res = new ExchangeRateDTO();
    Rate rate1 = getRate();




        switch (rate){

            case "usd":{
                res.setExchangeRate(rate1.getRates().getUsd());
                break;
            }
            case "uan":{
                res.setExchangeRate(rate1.getRates().getUah());
                break;
            }
            case "rub":{
                res.setExchangeRate(rate1.getRates().getRub());
           break;
            } default:res.setExchangeRate(0.0);


    }
        res.setDate(rate1.getDate());


        return res;

    }



}
