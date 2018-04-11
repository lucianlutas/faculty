package DataAccess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/theater";
    private static final String USER = "root";
    private static final String PASS = "";

    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnection(){
        return instance.createConnection();
    }

    public static void close (Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                /*Ignore*/
            }
        }
    }

    public static void close (Statement statement){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                /*Ignore*/
            }
        }
    }

    public static void close (ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                /*Ignore*/
            }
        }
    }

}