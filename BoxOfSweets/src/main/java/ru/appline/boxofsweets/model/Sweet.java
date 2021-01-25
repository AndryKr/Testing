package ru.appline.boxofsweets.model;

public abstract class Sweet {
    protected String name;
    protected Double weight;
    protected Double price;

    public Sweet(String name, Double weight, Double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public abstract String toString();
}
