package ru.appline.boxofsweets.model;

public class Apple extends Sweet {
    private Integer id = 1;
    private String name = "Apple";
    private Double weight = 1.2;
    private Double price = 10.0;

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Сладость {" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", вес=" + weight +
                ", цена=" + price +
                '}';
    }
}
