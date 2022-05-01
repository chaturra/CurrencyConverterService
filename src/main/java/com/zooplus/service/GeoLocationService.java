package com.zooplus.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;

@Service
public interface GeoLocationService {
    String getIsoCodeByIp(String ip) throws IOException, GeoIp2Exception;
}
