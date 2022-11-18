package nur.p3.patrondao.dao;

import nur.p3.patrondao.shared.DaoException;

public class FactoryDaoMySql implements FactoryDao {
    @Override
    public PersonaDao getPersonaDao() throws DaoException {
        return new PersonaDaoMySql();
    }
}
