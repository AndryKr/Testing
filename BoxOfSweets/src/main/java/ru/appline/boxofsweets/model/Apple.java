package ru.appline.boxofsweets.model;

public class Apple extends Sweet {

    private String color;

    public Apple(String color, String name, Double weight, Double price) {
        super(name, weight, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Сладость{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
