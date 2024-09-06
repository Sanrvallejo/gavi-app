package com.sena.gavi.model.entities;

import com.sena.gavi.enums.Category;
import com.sena.gavi.enums.Tax;
import com.sena.gavi.enums.Units;

import java.util.Date;

public class Product {
    private String id;
    private Date cretaedAt;
    private Date updatedAt;
    private String code;
    private String name;
    private Category category;
    private Double amount;
    private Units unit;
    private Double cost;
    private Double price;
    private Double profit;
    private Tax tax;

    public Product() {
    }

    public Product(Date cretaedAt, Date updatedAt, String name, Category category, Double amount,
                   Units unit, Double cost, Double price, Double profit, Tax tax) {
        this.cretaedAt = cretaedAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.unit = unit;
        this.cost = cost;
        this.price = price;
        this.profit = profit;
        this.tax = tax;
    }

    // Getters and setters...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCretaedAt() {
        return cretaedAt;
    }

    public void setCretaedAt(Date cretaedAt) {
        this.cretaedAt = cretaedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
