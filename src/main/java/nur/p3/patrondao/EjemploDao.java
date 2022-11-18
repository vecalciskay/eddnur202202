package nur.p3.patrondao;

import nur.p3.listas.Lista;
import nur.p3.patrondao.dao.FactoryDao;
import nur.p3.patrondao.dao.FactoryDaoSingleton;
import nur.p3.patrondao.dao.PersonaDao;
import nur.p3.patrondao.dao.PersonaDaoMySql;
import nur.p3.patrondao.dto.PersonaDto;
import nur.p3.patrondao.shared.DaoException;

import java.sql.Date;

/**
 * Business Object
 */
public class EjemploDao {
    public static void main(String[] args) throws DaoException {

        FactoryDao factory = FactoryDaoSingleton.getFactoryDao();
        // DataAccessObject (esconde el DataSource)
        PersonaDao daoPersona = factory.getPersonaDao();
        // Select
        PersonaDto p = daoPersona.get(1);
        System.out.println(p);

        // Update
        p.setNombre("Paco");
        daoPersona.update(p);
        System.out.println(p);

        // Insert
        Date fn = Date.valueOf("1980-01-01");
        PersonaDto p2 = new PersonaDto("Luis", 1.80f, fn);
        daoPersona.insert(p2);
        System.out.println(p2);

        // Select *
        System.out.println("Todos los registros");
        Lista<PersonaDto> personas = daoPersona.getAll();
        for(PersonaDto persona : personas) {
            System.out.println(persona);
        }

        // Delete
        System.out.println("Borrando registro con id " + p2.getId());
        daoPersona.delete(p2.getId());

        /*
        MateriaDao daoMateria = new MateriaDao();
        MateriaDto m = daoMateria.get(1);
        */

    }
}
