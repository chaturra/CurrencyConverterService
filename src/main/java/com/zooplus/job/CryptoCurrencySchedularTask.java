package com.zooplus.job;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.entity.CryptoRatesEntity;
import com.zooplus.model.CryptoApiResponse;
import com.zooplus.model.PriceData;
import com.zooplus.repository.CryptoRatesRepository;
import com.zooplus.repository.rest.CryptoApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CryptoCurrencySchedularTask {
    private final CryptoApiClient cryptoApiClient;
    private final CryptoRatesRepository cryptoRatesRepository;

    @Scheduled(initialDelay = 300, fixedDelay = 10000000)
    public void process() throws URISyntaxException, IOException {
        log.info("calling makeapi");

        String response = cryptoApiClient.makeAPICall();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CryptoApiResponse cryptoApiResponse =
                objectMapper.readValue(response, CryptoApiResponse.class);

        List<PriceData> dataList = cryptoApiResponse.getData();

        List<String> crypto = dataList.stream()
                .map(PriceData::getName)
                .collect(Collectors.toList());


        List<CryptoRatesEntity> cryptoListEntity = new ArrayList<>();
        List<BigDecimal> cryptoPrice = dataList.stream()
                .map(PriceData::getQuote)
                .map(e->e.get("USD"))
                .map(cr->cr.getPrice())
                .collect(Collectors.toList());

        for(int i =0; i<100;) {
            CryptoRatesEntity cryptoRatesEntity = new CryptoRatesEntity();
            cryptoRatesEntity.setCryptoCurrencyName(crypto.get(i++));
            cryptoRatesEntity.setPrice(cryptoPrice.get(i++).toString());
            cryptoListEntity.add(cryptoRatesEntity);
        }


        cryptoRatesRepository.saveAll(cryptoListEntity);



    }
}
