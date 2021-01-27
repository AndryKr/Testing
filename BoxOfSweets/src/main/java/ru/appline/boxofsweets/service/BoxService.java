package ru.appline.boxofsweets.service;

import ru.appline.boxofsweets.model.Sweet;

public interface BoxService {

    double getTotalWeight();

    double getTotalPrice();

    void getInfoAdoutСontent();

    void optimizeByWeight(double weight);

    void optimizeByPrice(double weight);

    void put(Sweet sweet);

    void delete(int id);

    void delete();
}
