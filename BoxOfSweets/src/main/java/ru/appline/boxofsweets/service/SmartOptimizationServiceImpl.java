package ru.appline.boxofsweets.service;

import ru.appline.boxofsweets.dao.BoxDaoImpl;
import ru.appline.boxofsweets.model.Sweet;

import java.util.List;

public class SmartOptimizationServiceImpl implements SmartOptimizationService {

    private BoxDaoImpl boxDao = BoxDaoImpl.getInstance();
    private List<Sweet> sweets = boxDao.getBox().getSweets();
    private BoxServiceImpl boxService = BoxServiceImpl.getInstance();

    private static SmartOptimizationServiceImpl smartOptimizationService;

    private SmartOptimizationServiceImpl() {
    }

    public static SmartOptimizationServiceImpl getInstance() {
        if (smartOptimizationService == null) {
            smartOptimizationService = new SmartOptimizationServiceImpl();
        }
        return smartOptimizationService;
    }

    @Override
    public void optimizeByWeight(double weight) {
        sweets.sort((sweet1, sweet2) -> sweet1.getWeight().compareTo(sweet2.getWeight()));
        while (boxService.getTotalWeight() >= weight) {
            sweets.remove(0);
        }
    }

    @Override
    public void optimizeByPrice(double weight) {
        sweets.sort((sweet1, sweet2) -> sweet1.getPrice().compareTo(sweet2.getPrice()));
        while (boxService.getTotalWeight() >= weight) {
            sweets.remove(0);
        }
    }
}
