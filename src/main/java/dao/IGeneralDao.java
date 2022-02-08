package dao;

import java.util.List;

public interface IGeneralDao<T> {
    List<T> getAll();

    boolean add(T t);

    boolean update(int id, T t);

    boolean delete(int id);

    T findById(int id);
}
