package Main.java;
import java.sql.*;

public class MyJDBC2 {
    public static void main(String[] args) {

        Connection connection = null;


        try {

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "root");
            connection.setAutoCommit(false);


            Statement statement = connection.createStatement();



            String consultaSql = "SELECT * FROM estudiante";

            ResultSet resultSet = statement.executeQuery("SELECT * FROM estudiante");

            connection.commit();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }

        } catch (SQLException sqlException) {

            System.out.println(sqlException);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException sqlException1) {
                    System.out.println(sqlException1);
                }
            }

        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException);
            }

        }
    }
}
