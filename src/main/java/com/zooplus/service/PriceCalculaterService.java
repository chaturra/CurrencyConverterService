package com.zooplus.service;

import com.zooplus.model.CryptoRateResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public interface PriceCalculaterService {
    CryptoRateResponse getCryptoPrice(String cryptoCode, String ip) throws Exception;


}
