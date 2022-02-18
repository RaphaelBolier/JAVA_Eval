package com.TFT.ApiGateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    WeatherService delegate;

    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    public String getWeather()
    {
        return delegate.callWeatherServiceAndGetData();
    }

//    @RequestMapping(value = "zipCode/{zipCode}", method = RequestMethod.GET)
//    public String getWeatherbyZipCode(@PathVariable int weatherZipCode)
//    {
//        System.out.println("Getting weather details for " + weatherZipCode);
//
//        String response = restTemplate.exchange("localhost:8080/zipCode/{zipCode}",
//                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, weatherZipCode).getBody();
//
//        System.out.println("Response Body " + response);
//
//        return "Weather Zip Code -  " + weatherZipCode + " [ Weather Details " + response+" ]";
//    }
//
//    @RequestMapping(value = "cityName/{cityName}", method = RequestMethod.GET)
//    public String getWeathersByCityName(@PathVariable String weatherCityName)
//    {
//        System.out.println("Getting weather details for " + weatherCityName);
//
//        String response = restTemplate.exchange("localhost:8080/cityName/{cityName}",
//                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, weatherCityName).getBody();
//
//        System.out.println("Response Body " + response);
//
//        return "Weather City Name -  " + weatherCityName + " [ Weather Details " + response+" ]";
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
