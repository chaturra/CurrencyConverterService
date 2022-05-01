package com.zooplus.facade;

import com.zooplus.model.CryptoRateResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public interface CryptoPriceFacade {

    CryptoRateResponse getPrice(String cryptoCode, String ip) throws Exception;
}
