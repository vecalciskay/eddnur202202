package nur.p3.patrondao.shared;

import nur.p3.listas.Lista;

public interface Dao <T> {
    T get(int id) throws DaoException;
    Lista<T> getAll() throws DaoException;
    void insert(T t) throws DaoException;
    void update(T t) throws DaoException;
    void delete(int id) throws DaoException;
}
