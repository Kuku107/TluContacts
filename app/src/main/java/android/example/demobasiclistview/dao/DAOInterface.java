package android.example.demobasiclistview.dao;

import java.util.List;

public interface DAOInterface<T> {
    long insert(T entity);

    T getById(int id);

    List<T> getAll();
}
