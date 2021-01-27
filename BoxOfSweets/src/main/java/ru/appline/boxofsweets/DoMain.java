package ru.appline.boxofsweets;

import ru.appline.boxofsweets.model.*;
import ru.appline.boxofsweets.service.*;


public class DoMain {
    public static void main(String[] args) {
        BoxServiceImpl boxService = new BoxServiceImpl();
        boxService.put(new Apple("Red", "Apple", 1.2, 10.0));
        boxService.put(new Candy("Raffaello", "Candy", 0.3, 3.0));
        boxService.put(new Chocolate("Bitter", "Chocolate", 1.0, 15.0));
        boxService.put(new Raspberry("Fresh","Raspberry", 0.2, 2.0));
        boxService.put(new Raspberry("Fresh","Raspberry", 0.3, 3.0));

        boxService.delete(4);

        boxService.getInfoAdoutСontent();

        System.out.println("Вес коробки с содержимым: " + boxService.getTotalWeight());
        System.out.println("Цена коробки с содержимым: " + boxService.getTotalPrice());

        System.out.println();

        //TODO Открыть один из закоментированных блоков для проверки работы оптимизации.

        /*boxService.optimizeByPrice(2.3);
        boxService.getInfoAdoutСontent();*/

        /*boxService.optimizeByWeight(2.3);
        boxService.getInfoAdoutСontent();*/
    }
}
