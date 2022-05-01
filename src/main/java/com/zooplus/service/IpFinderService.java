package com.zooplus.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@Service
public interface IpFinderService {
    String getClientIp(HttpServletRequest httpServletRequest) throws UnknownHostException;
}
