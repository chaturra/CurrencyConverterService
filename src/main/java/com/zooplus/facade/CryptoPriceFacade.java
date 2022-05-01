package com.zooplus.facade;

import com.zooplus.model.CryptoRateResponse;


public interface CryptoPriceFacade {

    CryptoRateResponse getPrice(String cryptoCode, String ip) throws Exception;
}
