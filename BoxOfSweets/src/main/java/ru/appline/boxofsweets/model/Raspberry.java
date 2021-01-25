package ru.appline.boxofsweets.model;

public class Raspberry extends Sweet {

    private String condition;

    public Raspberry(String condition, String name, Double weight, Double price) {
        super(name, weight, price);
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Сладость{" +
                "condition=" + condition +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
