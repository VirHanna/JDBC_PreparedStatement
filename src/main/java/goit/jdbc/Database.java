package goit.jdbc;

import goit.jdbc.exception.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:h2:./test";
    private final Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Failed to connect to the database", e);
        }
    }

    private static class SingletonHelper {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
