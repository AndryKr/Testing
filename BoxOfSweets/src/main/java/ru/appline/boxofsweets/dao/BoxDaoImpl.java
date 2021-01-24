package ru.appline.boxofsweets.dao;

import ru.appline.boxofsweets.model.Box;
import ru.appline.boxofsweets.model.Sweet;

import java.util.List;

public class BoxDaoImpl implements BoxDao {

    private Box box = new Box();
    private List<Sweet> sweets = box.getSweets();
    private static BoxDaoImpl boxDao;

    private BoxDaoImpl() {
    }

    public static BoxDaoImpl getInstance() {
        if (boxDao == null) {
            boxDao = new BoxDaoImpl();
        }
        return boxDao;
    }

    @Override
    public void put(Sweet sweet) {
        sweets.add(sweet);
    }

    @Override
    public void delete(int id) {
        sweets.remove(id);
    }

    public void delete() {
        int lastIndex = sweets.size() - 1;
        sweets.remove(sweets.get(lastIndex));
    }

    public Box getBox() {
        return box;
    }
}
