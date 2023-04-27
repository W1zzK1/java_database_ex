package org.gorbunov.persistance;

import org.gorbunov.exception.IlligalDataException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private static final String DB_USER = "test";
    private static final String DB_PASSWORD = "test";

    private static Connection connection = null;
    private static DAO dao = null;

    public static DAO getInstance() {
        if (dao != null) {
            System.out.println("Подключено");
            return dao;
        } else {
            try {
                dao = new DAO();
                System.out.println("Подключено");
                return dao;
            } catch (SQLException e) {
                System.out.println("Не происходит подключение к " + DB_URL);
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
                throw new IlligalDataException();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public DAO() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
