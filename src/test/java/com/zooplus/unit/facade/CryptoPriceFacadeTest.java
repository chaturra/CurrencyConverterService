package com.zooplus.unit.facade;

import com.zooplus.facade.CryptoPriceFacade;
import com.zooplus.facade.Impl.CryptoPriceFacadeImpl;
import com.zooplus.model.CryptoRateResponse;
import com.zooplus.service.PriceCalculaterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CryptoPriceFacadeTest {

    @Mock
    PriceCalculaterService priceCalculaterService;

    CryptoPriceFacade cryptoPriceFacade;

    @BeforeEach
    void setUp() {
        cryptoPriceFacade = new CryptoPriceFacadeImpl(priceCalculaterService);
    }

    @Test
    void getPrice() throws Exception {
        CryptoRateResponse cryptoRateResponse = new CryptoRateResponse();
        Mockito.when(priceCalculaterService
                        .getCryptoPrice("Bitcoin", "10.23.56.102")).thenReturn(cryptoRateResponse);
        cryptoPriceFacade.getPrice("Bitcoin", "10.23.56.102");
        Mockito.verify(priceCalculaterService).getCryptoPrice("Bitcoin", "10.23.56.102");
    }
}