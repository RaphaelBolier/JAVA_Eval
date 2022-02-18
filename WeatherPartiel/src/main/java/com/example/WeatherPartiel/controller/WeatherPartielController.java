package com.example.WeatherPartiel.controller;

import com.example.WeatherPartiel.bean.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherPartielController {
    public static final List<Weather> weathers = new ArrayList<Weather>() {
        private static final long serialVersionUID = -3970206781360313502L;

        {
            add(new Weather(1,"Nice", "06000", "France",30));
            add(new Weather(2,"Marseille", "13000", "France",25));
            add(new Weather(3,"Bruxelles", "1000", "Belgique",20));
        }
    };

    @RequestMapping(
            name = "getWeather",
            method = RequestMethod.GET
    )
    public List<Weather> getWeather() {
        try {
            return weathers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(
            name = "getWeatherByPays",
            method = RequestMethod.GET,
            value = "country/{country}"
    )
    public List<Weather> getWeathersByPays(@PathVariable String pays){
        try {
            return weathers.stream()
                    .filter(weather -> pays.equals(weather.getCountry()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(
            name = "getWeatherByNom",
            method = RequestMethod.GET,
            value = "cityName/{cityName}"
    )
    public List<Weather> getWeathersByNom(@PathVariable String cityName){
        try {
            return weathers.stream()
                    .filter(weather -> cityName.equals(weather.getCityName()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(
            name = "getWeatherByCode",
            method = RequestMethod.GET,
            value = "zipCode/{zipCode}"
    )
    public List<Weather> getWeathersByCode(@PathVariable String zipCode){
        try {
            return weathers.stream()
                    .filter(weather -> zipCode.equals(weather.getZipCode()) )
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    @RequestMapping(
            name = "getWeatherByMeteo",
            method = RequestMethod.GET,
            value = "weather/{weather}"
    )
    public List<Weather> getWeathersByMeteo(@PathVariable String meteo){
        try {
            return weathers.stream()
                    .filter(weather -> meteo.equals(weather.getTemperature()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
