package ru.appline.boxofsweets.service;

public interface BoxService {

    double getTotalWeight();

    double getTotalPrice();

    void getInfoAdoutСontent();

    void optimizeByWeight(double weight);

    void optimizeByPrice(double weight);

}
