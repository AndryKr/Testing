package ru.appline.boxofsweets.service;

import ru.appline.boxofsweets.dao.BoxDaoImpl;
import ru.appline.boxofsweets.model.Sweet;

import java.util.List;

public class BoxServiceImpl implements BoxService {

    private BoxDaoImpl boxDao = BoxDaoImpl.getInstance();
    private List<Sweet> sweets = boxDao.getBox().getSweets();

    private static BoxServiceImpl boxService;

    private BoxServiceImpl(){}

    public static BoxServiceImpl getInstance() {
        if(boxService == null) {
            boxService = new BoxServiceImpl();
        }
        return boxService;
    }

    @Override
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Sweet swt: sweets) {
            totalWeight += swt.getWeight();
        }
        return totalWeight;
    }

    @Override
    public double getTotalPrice() {
        double totalTotalPrice = 0;
        for (Sweet swt: sweets) {
            totalTotalPrice += swt.getPrice();
        }
        return totalTotalPrice;
    }

    @Override
    public void getInfoAdoutСontent() {
        System.out.println("Содержимое коробки");
        for (Sweet swt: sweets) {
            System.out.println(swt.toString());
        }
        System.out.println("------------------------------");
    }
}
