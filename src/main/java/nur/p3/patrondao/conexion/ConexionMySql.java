package nur.p3.patrondao.conexion;

import nur.p3.patrondao.shared.DaoException;

import java.sql.*;

public class ConexionMySql extends Conexion {
    public ConexionMySql() throws DaoException {
        conectar();
    }

    @Override
    public void conectar() throws DaoException {
        try {
            conexion = DriverManager
                    .getConnection("jdbc:mysql://localhost:6603/edd?"
                            + "user=root&password=krane345");
        } catch (SQLException e) {
            throw new DaoException("No se pudo conectar a la BD: " + e.getMessage(), e);
        }
    }

    @Override
    public void desconectar() throws DaoException {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new DaoException("No se pudo desconectar de la BD: " + e.getMessage(), e);
        }
    }
}
