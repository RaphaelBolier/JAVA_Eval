package com.example.WeatherPartiel.bean;


import io.swagger.annotations.ApiModelProperty;

public class Weather {
    @ApiModelProperty(notes = "weather's Id", name = "id", required = true, value = "1")
    private int id;
    @ApiModelProperty(notes = "cityName", name = "cityName", required = true, value = "Nice")
    private String cityName;
    @ApiModelProperty(notes = "zipCode", name = "zipCode", required = true, value = "06300")
    private String zipCode;
    @ApiModelProperty(notes = "country", name = "country", required = true, value = "France")
    private String country;
    @ApiModelProperty(notes = "temperature", name = "temperature", required = true, value = "30")
    private int temperature;

    public Weather(int id, String cityName,String zipCode,String country,int temperature ){
        this.id = id;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.country = country;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
