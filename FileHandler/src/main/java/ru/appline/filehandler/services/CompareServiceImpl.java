package main.java.ru.appline.filehandler.services;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareServiceImpl implements CompareService {
    Map<String, Integer> map = new HashMap<>();

    public void wordsCounter(List<String> listOfWords) {
        for (String s1 : listOfWords) {
            int counter = 1;
            map.put(s1, counter);
            for (String s2 : listOfWords) {
                if (s1.equals(s2)) {
                    map.replace(s1, counter++);
                }
            }
        }
    }

    public void sortAlphabetically(List<String> listOfWords) {
        System.out.println("Сортировка слов по алфавиту:");
        listOfWords.sort((b1, b2) -> b1.compareTo(b2));
        System.out.println(listOfWords.toString() + "\n");
    }

    public void wordsStat() {
        System.out.println("Статистика встречающихся слов в файле:");
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println();
    }

    public void maxFrequencyWords() {
        System.out.println("Слова встречающиеся максимальное число раз:");
        System.out.println(map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get());
    }
}
