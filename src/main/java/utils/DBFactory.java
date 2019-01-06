package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBFactory {

    private static Connection getDBConnection() {

//        String DRIVER = "org.gjt.mm.mysql.Driver";
        String DRIVER = "com.mysql.jdbc.Driver";

        String connectionString =
                "jdbc:mysql://"
                        + PropertyManager.getInstance().getDatabaseServer()
                        + PropertyManager.getInstance().getDatabaseName();

        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(connectionString,
                                                    PropertyManager.getInstance().getDbUser(),
                                                    PropertyManager.getInstance().getDbPassword());
            connection.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void DBRunQuery(String query) throws SQLException {
        Statement stmt;

        stmt = getDBConnection().createStatement();
        stmt.executeUpdate(query);

        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
