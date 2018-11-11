package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBFactory {

    private static Connection getDBConnection() {

        String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";

        String connectionString =
                "jdbc:mysql://"
                        + PropertyManager.getInstance().getDatabaseServer()
                        + PropertyManager.getInstance().getDatabaseName();

        Connection connection = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(connectionString, "root", "root");
            connection.createStatement();
            System.out.println("Connected database successfully...");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro de conecxão");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ClassNotFoundException");
        }

        return connection;
    }

    public void DBRunQuery(String query) throws SQLException {
        Statement stmt;

        stmt = getDBConnection().createStatement();
        int a = stmt.executeUpdate(query);

        System.out.println("result = "+a);

//        ResultSet resultSet;
        //        resultSet = stmt.getResultSet();
//        System.out.println("result = "+resultSet);
//        System.out.println("result = "+stmt.toString());
//        System.out.println("result = "+stmt.toString());
//        while (resultSet.next()) {
//            System.out.println(
//                    resultSet.getString(1) + "  "
//                            + resultSet.getString(2) + "  "
//                            + resultSet.getString(3) + "  "
//                            + resultSet.getString(4) + "  "
//                            + resultSet.getString(5));
//        }
//
//        try {
//            resultSet.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultSet.toString();

        try {
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static ArrayList<String> DBGetQueryResults(String query) {
//        ResultSet resultSet = null;
//
//        DataSet ds = new DataSet();
//        List<string> list = new List<string>();
//
//        using(SqlCommand cmd = new SqlCommand(query, GetDBConnection()))
//        {
//            cmd.CommandTimeout = Int32.Parse(ConfigurationManager.AppSettings["DBConnectionTimeout"]);
//            cmd.Connection.Open();
//            DataTable table = new DataTable();
//            table.Load(cmd.ExecuteReader());
//            ds.Tables.Add(table);
//            cmd.Connection.Close();
//        }
//
//        if (ds.Tables[0].Columns.Count == 0) {
//            return null;
//        }
//
//        try {
//            for (int i = 0; i < ds.Tables[0].Columns.Count; i++) {
//                list.Add(ds.Tables[0].Rows[0][i].ToString());
//            }
//        } catch (Exception) {
//            return null;
//        }
//        return list;
//    }

}
