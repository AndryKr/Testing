package ru.appline.boxofsweets;

import ru.appline.boxofsweets.dao.*;
import ru.appline.boxofsweets.model.*;
import ru.appline.boxofsweets.service.*;


public class DoMain {
    public static void main(String[] args) {
        BoxDaoImpl boxDao = BoxDaoImpl.getInstance();
        BoxServiceImpl boxService = BoxServiceImpl.getInstance();
        SmartOptimizationServiceImpl smartOptimizationService = SmartOptimizationServiceImpl.getInstance();
        boxDao.put(new Apple());
        boxDao.put(new Candy());
        boxDao.put(new Chocolate());
        boxDao.put(new Raspberry());

        boxService.getInfoAdoutСontent();

        System.out.println("Вес коробки с содержимым: " + boxService.getTotalWeight());
        System.out.println("Цена коробки с содержимым: " + boxService.getTotalPrice());

        System.out.println();

        //TODO Открыть один из закоментированных блоков для проверки работы оптимизации.

        /*smartOptimizationService.optimizeByPrice(2.3);
        boxService.getInfoAdoutСontent();*/

        /*smartOptimizationService.optimizeByWeight(2.3);
        boxService.getInfoAdoutСontent();*/
    }
}
