package ru.appline.boxofsweets.model;

public class Chocolate extends Sweet {

    private String taste;

    public Chocolate(String taste, String name, Double weight, Double price) {
        super(name, weight, price);
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Сладость{" +
                "taste=" + taste +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
