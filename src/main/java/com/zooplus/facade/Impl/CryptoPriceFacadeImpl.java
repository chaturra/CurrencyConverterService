package com.zooplus.facade.Impl;

import com.zooplus.facade.CryptoPriceFacade;
import com.zooplus.model.CryptoRateResponse;
import com.zooplus.service.PriceCalculaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CryptoPriceFacadeImpl implements CryptoPriceFacade {

    private final PriceCalculaterService priceCalculaterService;

    @Override
    public CryptoRateResponse getPrice(String cryptoCode, String ip) throws Exception {
        CryptoRateResponse cryptoRateResponse =
                priceCalculaterService.getCryptoPrice(cryptoCode, ip);
        return cryptoRateResponse;
    }
}
