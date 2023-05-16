package org.gorbunov.storage;

import java.sql.SQLException;
import java.util.List;

public interface Storage<T> {
    T getById(Integer id) throws SQLException;
    List<T> showAll() throws SQLException;
    T add(T entity) throws SQLException;

    default void update(Integer id, T entity) throws SQLException{
        return;
    }

    default void delete(Integer id) throws SQLException{
        return;
    }
}
