package nur.p3.bd;

import java.sql.*;

public class ConsultaSimple {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:6603/edd?"
                            + "user=root&password=krane345");

            System.out.println("Conectado");

            // Statements allow to issue SQL queries to the database
            Statement statement = connect.createStatement();
            // Result set get the result of the SQL query
            ResultSet resultSet = statement
                    .executeQuery("select * from personas");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                float altura = resultSet.getFloat("altura");
                Date fecha = resultSet.getDate("fechanacimiento");

                System.out.println(id + " | " + nombre + " | " + altura + " | " + fecha);
            }

            connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
