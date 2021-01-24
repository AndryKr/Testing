package ru.appline.boxofsweets.model;

public class Chocolate extends Sweet {
    private Integer id = 3;
    private String name = "Chocolate";
    private Double weight = 1.0;
    private Double price = 15.0;

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
