package com.zooplus.controller;

import com.zooplus.facade.CryptoPriceFacade;
import com.zooplus.model.CryptoRateResponse;
import com.zooplus.service.IpFinderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("v1/zoo")
@RequiredArgsConstructor
public class CryptoPriceController {

   private final CryptoPriceFacade cryptoPriceFacade;
   private final IpFinderService ipFinderService;
    /**
     * This end point can be triggered when it is required to read the crypto rates price for
     * different crypto currency ex. Bitcoin,Tether, USD Coin etc
     * This will return a JSON response with price and price sign
     * code 200 once completed
     * @return
     */
    @GetMapping(value = {"/cryptoRates/{cryptoCurrencyCode}/{ip}", "/cryptoRates/{cryptoCurrencyCode}"})
    public ResponseEntity<CryptoRateResponse> getReferenceRates(
            @PathVariable String cryptoCurrencyCode, @PathVariable(required = false) String ip,
            HttpServletRequest httpServletRequest ) throws Exception {

        if (ip == null || ip.isEmpty()) {
            log.info("ip is null");
            ip = ipFinderService.getClientIp(httpServletRequest);

        }

        CryptoRateResponse cryptoRateResponse = cryptoPriceFacade.getPrice(
                cryptoCurrencyCode, ip);

        return ResponseEntity.ok(cryptoRateResponse);

    }

}
