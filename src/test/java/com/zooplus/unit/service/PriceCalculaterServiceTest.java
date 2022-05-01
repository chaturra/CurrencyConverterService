package com.zooplus.unit.service;

import com.zooplus.entity.CryptoRatesEntity;
import com.zooplus.repository.CryptoRatesRepository;
import com.zooplus.service.Impl.PriceCalculaterServiceImpl;
import com.zooplus.service.PriceCalculaterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceCalculaterServiceTest {

    @Mock
    CryptoRatesRepository cryptoRatesRepository;


    PriceCalculaterService priceCalculaterService;

    @BeforeEach
    void setUp() {
        priceCalculaterService = new PriceCalculaterServiceImpl(cryptoRatesRepository);
    }

    @Test
    void getCryptoPrice() throws Exception {
        CryptoRatesEntity cryptoRatesEntity = new CryptoRatesEntity();
        cryptoRatesEntity.setCryptoCurrencyName("Bitcoin");
        cryptoRatesEntity.setPrice("300.76");
        Mockito.when(cryptoRatesRepository.findById("Bitcoin"))
                .thenReturn(java.util.Optional.of(cryptoRatesEntity));
        assertNotNull(priceCalculaterService.getCryptoPrice("Bitcoin", "10.25.36.78"));
        Mockito.verify(cryptoRatesRepository).findById("Bitcoin");

    }
}