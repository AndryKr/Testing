package ru.appline.boxofsweets.model;

public class Candy extends Sweet {
    private Integer id = 2;
    private String name = "Candy";
    private Double weight = 0.3;
    private Double price = 3.0;

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
