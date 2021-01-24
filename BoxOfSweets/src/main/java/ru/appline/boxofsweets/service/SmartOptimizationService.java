package ru.appline.boxofsweets.service;

import ru.appline.boxofsweets.model.Box;

public interface SmartOptimizationService {
    void optimizeByWeight(double weight);

    void optimizeByPrice(double weight);
}
