package ru.appline.boxofsweets.dao;

import ru.appline.boxofsweets.model.Sweet;

public interface BoxDao {

    void put(Sweet sweet);

    void delete(int id);

    void delete();
}
