package org.gorbunov.storage;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetProcessor<T> {
    T process (ResultSet rs) throws SQLException;
}
