package nur.p3.patrondao.dao;

import nur.p3.listas.Lista;
import nur.p3.patrondao.conexion.Conexion;
import nur.p3.patrondao.conexion.ConexionMySql;
import nur.p3.patrondao.dto.PersonaDto;
import nur.p3.patrondao.shared.DaoException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonaDaoMySql implements PersonaDao {

    private final Conexion conexion;

    public PersonaDaoMySql() throws DaoException {
        conexion = new ConexionMySql();
    }

    public PersonaDto get(int id) throws DaoException {

        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personas WHERE id = " + id);
            if (rs.next()) {
                return new PersonaDto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("altura"),
                        rs.getDate("fechanacimiento")
                );
            }
        } catch (Exception e) {
            throw new DaoException("No pudo obtener Persona con id " + id, e);
        }

        return null;
    }

    @Override
    public Lista<PersonaDto> getAll() throws DaoException {
        Lista<PersonaDto> personas = new Lista<>();

        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id, nombre, altura, fechanacimiento FROM personas");
            while (rs.next()) {
                personas.insertar(new PersonaDto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("altura"),
                        rs.getDate("fechanacimiento")
                ));
            }
        } catch (Exception e) {
            throw new DaoException("No pudo obtener Personas", e);
        }

        return personas;
    }

    @Override
    public void insert(PersonaDto personaDto) throws DaoException {

            try {
                Statement st = conexion.getConexion().createStatement();
                int numeroFilasAfectadas =
                        st.executeUpdate("INSERT INTO personas (nombre, altura, fechanacimiento) VALUES ('" +
                        personaDto.getNombre() + "', " +
                        personaDto.getAltura() + ", '" +
                        personaDto.getFechaSql() + "')",
                        Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                int id = 0;
                if (rs.next()){
                    id = rs.getInt(1);
                }
                personaDto.setId(id);
            } catch (Exception e) {
                throw new DaoException("No pudo insertar Persona", e);
            }

    }

    @Override
    public void update(PersonaDto p) throws DaoException {
        try {
            Statement st = conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE personas SET " +
                    "nombre = '" + p.getNombre() +
                    "', altura=" + p.getAltura() +
                    ", fechanacimiento='" + p.getFechaSql() +
                    "' WHERE id = " + p.getId());
        } catch (Exception e) {
            throw new DaoException("No pudo actualizar Persona con id " + p.getId(), e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try {
            Statement st = conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM personas WHERE id = " + id);
        } catch (Exception e) {
            throw new DaoException("No pudo borrar Persona con id " + id, e);
        }
    }
}
