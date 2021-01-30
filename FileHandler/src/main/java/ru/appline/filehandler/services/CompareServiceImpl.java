package main.java.ru.appline.filehandler.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CompareServiceImpl implements CompareService {

    public void wordsCounter(List<String> listOfWords) {
        Map<String, Integer> map = new HashMap<>();
        for (String s1 : listOfWords) {
            int counter = 1;
            map.put(s1, counter);
            for (String s2 : listOfWords) {
                if (s1.equals(s2)) {
                    map.replace(s1, counter++);
                }
            }
        }

        System.out.println("Статистика встречающихся слов в файле:");
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("Слова встречающееся максимальное число раз:");
        Optional<Map.Entry<String, Integer>> min = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        System.out.print(min.get());
    }
}
