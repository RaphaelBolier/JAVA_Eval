package com.example.WeatherPartiel.bean;


public class Weather {
    private int id;
    private String cityName;
    private String zipCode;
    private String country;
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
