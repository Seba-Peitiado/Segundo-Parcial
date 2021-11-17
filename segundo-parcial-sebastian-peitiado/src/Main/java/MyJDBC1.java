package Main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC1 {

    public static void main(String[] args) {

        Connection connection = null;
        try{

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM personas;");

            System.out.println(resultSet);



            while(resultSet.next()){
                System.out.println(resultSet.getString("idpersonas") + " " + resultSet.getString("Nombre"));
            }

        }catch (Exception e){

            e.printStackTrace();


        }

    }

}