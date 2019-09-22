package com.concurrent;

import com.datatype.UrlRequestCall;
import org.springframework.web.client.RestTemplate;

public class UrlRequestJob extends Job {

    private UrlRequestCall urlRequestCall;

    public UrlRequestJob(UrlRequestCall urlRequestCall)
    {
        this.urlRequestCall = urlRequestCall;
    }

    @Override
    public Object execute() throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(urlRequestCall.getUrl(), String.class);
        return null;
    }
}
