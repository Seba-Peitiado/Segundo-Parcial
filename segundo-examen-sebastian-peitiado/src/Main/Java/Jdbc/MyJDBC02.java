package Main.Java.Jdbc;

import java.sql.*;



public class MyJDBC02 {
    public static void main(String[] args) {

        Connection connection = null;

        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost/sebastian-peitiado", "root", "");
            connection.setAutoCommit(false);

            PreparedStatement consultaPreparada = connection.prepareStatement("INSERT INTO estudiantes (dni, nombre, apellido) VALUES (?, ?, ?);");


            consultaPreparada.setString(1,"41781351");
            consultaPreparada.setString(2,"Sebastian");
            consultaPreparada.setString(3,"peitiado");


            consultaPreparada.executeUpdate();

            connection.commit();

            ResultSet resultSet = consultaPreparada.executeQuery("SELECT * FROM estudiantes");

            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }

        }catch (SQLException sqlException1){

            System.out.println(sqlException1);
            if(connection != null){
                try{
                    connection.rollback();
                } catch (SQLException sqlException2){
                    System.out.println(sqlException2);
                }
            }

        }finally{

            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException sqlException3){
                System.out.println(sqlException3);
            }

        }

    }

}
