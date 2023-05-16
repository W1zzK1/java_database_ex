package org.gorbunov.persistance;

import java.sql.Connection;

public interface DataAccessObject {

    Connection getConnection();
}
