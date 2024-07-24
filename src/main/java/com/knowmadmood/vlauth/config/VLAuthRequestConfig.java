package com.knowmadmood.vlauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VLAuthRequestConfig {

    @Value("${request.url}")
    private String requestUrl;
    @Value("${request.contenttype}")
    private String requestContentType;
    @Value("${request.data}")
    private String requestData;

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getRequestContentType() {
        return requestContentType;
    }

    public String getRequestData() {
        return requestData;
    }
}
