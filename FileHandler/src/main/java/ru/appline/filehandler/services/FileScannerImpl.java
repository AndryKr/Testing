package main.java.ru.appline.filehandler.services;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileScannerImpl implements FileScanner {

    public List<String> readFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            List<String> listOfWords = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String input;
                while ((input = br.readLine()) != null) {
                    String[] inputArray = (input + " ").toLowerCase().split("\\p{P}?[ \\t\\n\\r]+");
                    Collections.addAll(listOfWords, inputArray);
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла.");
            }
            Collections.sort(listOfWords);
            return listOfWords;
        } else {
            System.out.println("Файл отсутствует");
            return null;
        }
    }
}