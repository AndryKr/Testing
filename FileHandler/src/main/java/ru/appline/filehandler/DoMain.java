package main.java.ru.appline.filehandler;

import main.java.ru.appline.filehandler.services.CompareService;
import main.java.ru.appline.filehandler.services.CompareServiceImpl;
import main.java.ru.appline.filehandler.services.FileScanner;
import main.java.ru.appline.filehandler.services.FileScannerImpl;

import java.util.List;

public class DoMain {
    public static void main(String[] args) {

        FileScanner fileScanner = new FileScannerImpl();
        CompareService compareService = new CompareServiceImpl();
        List<String> list = fileScanner.readFile("src/main/resources/Word.txt");
        compareService.sortAlphabetically(list);
        compareService.wordsCounter(list);
        compareService.wordsStat();
        compareService.maxFrequencyWords();
    }
}
