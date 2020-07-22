package com.bacon.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lrod
 */
public class Item {

    protected long id;
    protected String name;
    protected String measure;
    protected double quantity;
    private int location;

    private BigDecimal cost;
    private BigDecimal price;
    private BigDecimal average;
    private double init;
    private double stockMin;
    private double stock;

    private List<Object[]> presentations;

    private Date updateTime;
    private String user;

    public Item() {
        this.presentations = new ArrayList<>();
    }

    public Item(long id) {        
        this.id = id;
        this.presentations = new ArrayList<>();
    }

    public Item(long id, String code, String name, String medida) {
        this.id = id;
        this.name = name;
        this.measure = medida;
        this.presentations = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public double getInit() {
        return init;
    }

    public void setInit(double init) {
        this.init = init;
    }

    public double getStockMin() {
        return stockMin;
    }

    public void setStockMin(double stockMin) {
        this.stockMin = stockMin;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Object[]> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Object[]> presentations) {
        this.presentations = presentations;
    }

    public void addPresentations(int idPresentation, double cant) {
        if (presentations == null) {
            presentations = new ArrayList<>();
        }
        presentations.add(new Object[]{idPresentation, cant});
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " -> " + Arrays.toString(getPresentations().toArray(new Object[1]));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item ing = (Item) obj;
        return name.equalsIgnoreCase(ing.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
