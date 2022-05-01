package com.zooplus.service.Impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.entity.CryptoRatesEntity;
import com.zooplus.model.CryptoApiResponse;
import com.zooplus.model.CryptoRateResponse;
import com.zooplus.model.PriceData;
import com.zooplus.model.PriceInfo;
import com.zooplus.repository.CryptoRatesRepository;
import com.zooplus.repository.rest.CryptoApiClient;
import com.zooplus.service.PriceCalculaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;


@Component
@RequiredArgsConstructor
@Slf4j
public class PriceCalculaterServiceImpl implements PriceCalculaterService {

    private final CryptoRatesRepository cryptoRatesRepository;

    @Override
    public CryptoRateResponse getCryptoPrice(String cryptoCode, String ip) throws Exception {

       CryptoRatesEntity cryptoRatesEntity =
               cryptoRatesRepository.findById(cryptoCode).orElseThrow(Exception::new);

        CryptoRateResponse cryptoRateResponse = CryptoRateResponse.builder()
                .price(BigDecimal.valueOf(Double.valueOf(cryptoRatesEntity.getPrice())))
                .sign("$")
                .build();

        return cryptoRateResponse;
    }
}
