package Main.Java.Jdbc;

import java.sql.*;

public class MyJDBC01 {
    public static void main(String[] args) {

        Connection connection = null;

        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sebastian-peitiado", "root", "");

            Statement statement = connection.createStatement();

            String sqlString = "SELECT * FROM estudiantes";

            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }

        }catch (SQLException sqlException1){

            System.out.println(sqlException1);

        }finally {

            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException sqlException3){
                System.out.println(sqlException3);
            }

        }

    }
}
