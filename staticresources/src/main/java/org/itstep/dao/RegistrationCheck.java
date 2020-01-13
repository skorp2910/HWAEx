package org.itstep.dao;

import java.sql.*;

public class RegistrationCheck {
    private static final String SELECT = "select login,password from users";
    protected Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public RegistrationCheck(String connectionString, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(connectionString, user, password);
        DatabaseMetaData metaData = connection.getMetaData();
        if (metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        }
    }

    public boolean checkAutorisation(String loginA, String passwordA) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                if (loginA.equals(resultSet.getString("login")) && passwordA.equals(resultSet.getString("password"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
