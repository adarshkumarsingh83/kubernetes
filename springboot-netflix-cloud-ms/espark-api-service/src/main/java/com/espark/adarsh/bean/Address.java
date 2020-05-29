package com.espark.adarsh.bean;

public class Address implements BeanInf {

    private Long id;
    private String streetName;
    private String cityName;
    private String country;
    private Type type = Type.ADDRESS;

    public Address() {

    }

    public Address(Long id, String streetName, String cityName, String country) {
        this.id = id;
        this.streetName = streetName;
        this.cityName = cityName;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}

