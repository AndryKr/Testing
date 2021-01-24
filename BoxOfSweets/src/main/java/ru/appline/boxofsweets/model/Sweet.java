package ru.appline.boxofsweets.model;

public abstract class Sweet {
    Integer id;
    String name;
    Double weight;
    Double price;

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Сладость{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
