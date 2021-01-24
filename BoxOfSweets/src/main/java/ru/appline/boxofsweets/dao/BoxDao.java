package ru.appline.boxofsweets.dao;

import ru.appline.boxofsweets.model.Sweet;

public interface BoxDao {

    void put(Sweet sweet);

    void delete(int id); //todo: перегрузить, можно удалять по id или последний

    void delete();
}
