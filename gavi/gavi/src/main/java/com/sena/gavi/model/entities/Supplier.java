package com.sena.gavi.model.entities;

public class Supplier {
    private String id;
    private String name;
    private String nit;
    private String city;

    public Supplier() {
    }

    public Supplier(String name, String nit, String city) {
        this.name = name;
        this.nit = nit;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
