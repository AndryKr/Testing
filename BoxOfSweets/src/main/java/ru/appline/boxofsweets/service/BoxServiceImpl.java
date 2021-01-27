package ru.appline.boxofsweets.service;

import ru.appline.boxofsweets.model.Box;
import ru.appline.boxofsweets.model.Sweet;

import java.util.List;

public class BoxServiceImpl implements BoxService {

    private Box box = new Box();
    private List<Sweet> sweets = box.getSweets();

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

    @Override
    public void optimizeByWeight(double weight) {
        sweets.sort((sweet1, sweet2) -> sweet1.getWeight().compareTo(sweet2.getWeight()));
        while (getTotalWeight() >= weight) {
            sweets.remove(0);
        }
    }

    @Override
    public void optimizeByPrice(double weight) {
        sweets.sort((sweet1, sweet2) -> sweet1.getPrice().compareTo(sweet2.getPrice()));
        while (getTotalWeight() >= weight) {
            sweets.remove(0);
        }
    }

    @Override
    public void put(Sweet sweet) {
        sweets.add(sweet);
    }

    @Override
    public void delete(int id) {
        sweets.remove(id);
    }

    @Override
    public void delete() {
        int lastIndex = sweets.size() - 1;
        sweets.remove(sweets.get(lastIndex));
    }
}
