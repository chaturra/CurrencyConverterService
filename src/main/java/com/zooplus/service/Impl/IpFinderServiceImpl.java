package com.zooplus.service.Impl;

import com.zooplus.service.IpFinderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Component
@RequiredArgsConstructor
@Slf4j
public class IpFinderServiceImpl implements IpFinderService {

    private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    @Override
    public String getClientIp(HttpServletRequest request) throws UnknownHostException {
        log.info("print servlet request : " +request);

        String ip = request.getHeader("X-Forwarded-For");
        if( ip==null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip==null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip==null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(LOCALHOST_IPV4.equals(ip) || LOCALHOST_IPV6.equals(ip)) {
                InetAddress inetAddress = InetAddress.getLocalHost();
                ip = inetAddress.getHostAddress();
            }
        }

        if(ip!=null && !ip.isEmpty()
                && ip.length() > 15
                && ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        log.info("ipAddress : " +ip);
        return ip;
    }
}
