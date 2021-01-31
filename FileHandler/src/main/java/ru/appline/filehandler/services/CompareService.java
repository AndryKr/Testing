package main.java.ru.appline.filehandler.services;

import java.util.List;

public interface CompareService {

    void sortAlphabetically(List<String> listOfWords);

    void wordsCounter(List<String> inputAsList);

    void wordsStat();

    void maxFrequencyWords();


}
