package main.java.ru.appline.filehandler.services;

import java.util.List;

public interface FileScanner {

    List<String> readFile(String path);
}
