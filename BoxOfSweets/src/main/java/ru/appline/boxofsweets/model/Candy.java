package ru.appline.boxofsweets.model;

public class Candy extends Sweet {

    private String brand;

    public Candy(String brand, String name, Double weight, Double price) {
        super(name, weight, price);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Сладость{" +
                "brand=" + brand +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
