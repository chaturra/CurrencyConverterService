package com.zooplus.service.Impl;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import com.zooplus.service.GeoLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;


@Component
@Slf4j
public class GeoLocationServiceImpl implements GeoLocationService {
    @Value("${maxmind_account_id}")
    private Integer accountId;

    @Value("${maxmind_license_key}")
    private String licenseKey;

    @Override
    public String getIsoCodeByIp(String ip) throws IOException, GeoIp2Exception {
        WebServiceClient client = new WebServiceClient.Builder(accountId, licenseKey)
                .build();

        InetAddress ipAddress = InetAddress.getByName(ip);

        CountryResponse response = client.country(ipAddress);

        Country country = response.getCountry();
        log.info("Country ISO Code : " + country.getIsoCode()) ;
        return country.getIsoCode();
    }
}
