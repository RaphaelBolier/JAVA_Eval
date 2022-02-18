package com.TFT.ApiGateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "weatherNotFoundFallback")
    public String callWeatherServiceAndGetData() {
        System.out.println("Getting weather details");
        String response = restTemplate
                .exchange("http://localhost:8080/"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return  " Weather Details " + response + " -  " + new Date();
    }
    @SuppressWarnings("unused")
    private String weatherNotFoundFallback() {
        System.out.println("Weather Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - ";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
