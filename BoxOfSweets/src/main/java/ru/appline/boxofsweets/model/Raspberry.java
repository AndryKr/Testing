package ru.appline.boxofsweets.model;

public class Raspberry extends Sweet {
    private Integer id = 4;
    private String name = "Raspberry";
    private Double weight = 0.2;
    private Double price = 2.0;

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
